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
                        BranchStep.<String, String, String>of(
                                (context, input) -> {
                                    if (new Random().nextBoolean()) {
                                        return new CheckpointWithOutput<>(
                                                Checkpoint.of("TRAIN_AVAILABLE"),
                                                "Train Available"
                                        );
                                    }
                                    return new CheckpointWithOutput<>(Checkpoint.of("CAB_AVAILABLE"), "Cab Available");
                                },
                                (in, sub) -> {
                                    sub.on(
                                            Checkpoint.of("TRAIN_AVAILABLE"), () -> Sequence.begin()
                                                    .addStep(Step.of(
                                                            Checkpoint.of("BOOK_TRAIN"),
                                                            (context, input) -> "Train Booked"
                                                    ))
                                    );

                                    sub.on(
                                            Checkpoint.of("CAB_AVAILABLE"), () -> Sequence.begin()
                                                    .addStep(Step.of(
                                                            Checkpoint.of("BOOK_CAB"),
                                                            (context, input) -> "Cab Booked"
                                                    ))
                                    );
                                }
                        )
                )
                .addStep(
                        Step.of(Checkpoint.of("Send Booking"), (context, input) -> "Booking sent")
                );
        persistentFlowContext.registerSequence(sequence);
    }
}
