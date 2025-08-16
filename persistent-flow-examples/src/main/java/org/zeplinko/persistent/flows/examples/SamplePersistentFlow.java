package org.zeplinko.persistent.flows.examples;

import org.zeplinko.persistent.flows.api.Checkpoint;
import org.zeplinko.persistent.flows.api.PersistentFlow;
import org.zeplinko.persistent.flows.api.PersistentFlowContext;
import org.zeplinko.persistent.flows.api.ThrowingRunnable;

import java.util.ArrayList;

public class SamplePersistentFlow implements PersistentFlow {
    @Override
    public void initialise(PersistentFlowContext context) {
        Checkpoint hotelBookedCheckpoint = Checkpoint.of("HOTEL_BOOKED");
        Checkpoint flightBookedCheckpoint = Checkpoint.of("FLIGHT_BOOKED");

        context.register(
                Checkpoint.of("BEGIN"), new ArrayList<Checkpoint>() {{
                    add(hotelBookedCheckpoint);
                }}, new BookHotel()
        );

        context.register(
                hotelBookedCheckpoint, new ArrayList<Checkpoint>() {{
                    add(flightBookedCheckpoint);
                }}, () -> {
                    System.out.println("Booking Flight");
                    System.out.println("Flight Booked");
                }
        );
    }

    private static class BookHotel implements ThrowingRunnable {
        @Override
        public void run() {
            System.out.println("Booking Hotel");
            System.out.println("Hotel Booked");
        }
    }


}
