package org.zeplinko.persistent.flows.examples;

import org.zeplinko.persistent.flows.api.*;

import java.util.Random;

public class SamplePersistentFlow2 implements PersistentFlow {
    @Override
    public void initialise(PersistentFlowContext persistentFlowContext) {
        Sequence<String> sequence = Sequence.begin()
                .addStep(
                        Step.of(Checkpoint.of("BOOK_HOTEL"), (context, input) -> "Hotel Booked")
                )
                .addStep(
                        BranchStep.<TransportChoice, String, String, String>of(
                                        (context, input) -> {
                                            int randomInt = new Random().nextInt(20);
                                            if (randomInt > 10) {
                                                return new CheckpointWithOutput<>(
                                                        Checkpoint.of(TransportChoice.TRAIN_AVAILABLE),
                                                        "Train Available"
                                                );
                                            }
                                            if (randomInt > 5) {
                                                return new CheckpointWithOutput<>(
                                                        Checkpoint.of(TransportChoice.BUS_AVAILABLE),
                                                        "Bus Available"
                                                );
                                            }
                                            return new CheckpointWithOutput<>(
                                                    Checkpoint.of(TransportChoice.CAB_AVAILABLE),
                                                    "Cab Available"
                                            );
                                        }
                                )
                                .on(
                                        Checkpoint.of(TransportChoice.TRAIN_AVAILABLE),
                                        s -> Sequence.begin().addStep(Step.of(
                                                Checkpoint.of("BOOK_TRAIN"),
                                                (context, input) -> "Train Booked"
                                        ))
                                )
                                .on(
                                        Checkpoint.of(TransportChoice.BUS_AVAILABLE),
                                        s -> Sequence.begin().addStep(Step.of(
                                                Checkpoint.of("BOOK_BUS"),
                                                (context, input) -> "Bus Booked"
                                        ))
                                )
                                .on(
                                        Checkpoint.of(TransportChoice.CAB_AVAILABLE),
                                        s -> Sequence.begin().addStep(Step.of(
                                                Checkpoint.of("BOOK_CAB"),
                                                (context, input) -> "Cab Booked"
                                        ))
                                )
                )
                .addStep(
                        Step.of(Checkpoint.of("Send Booking"), (context, input) -> "Booking sent")
                );
        persistentFlowContext.registerSequence(sequence);
    }
}
