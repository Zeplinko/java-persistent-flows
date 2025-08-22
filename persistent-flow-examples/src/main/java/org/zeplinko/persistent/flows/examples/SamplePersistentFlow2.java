package org.zeplinko.persistent.flows.examples;

import org.zeplinko.persistent.flows.api.*;

import java.util.Random;

public class SamplePersistentFlow2 implements PersistentFlow {
    @Override
    public void initialise(PersistentFlowContext persistentFlowContext) {
        Sequence<String> sequence = Sequence.begin()
                .addStep(
                        Step.of(Checkpoint.of("BOOK_FLIGHT"), (context, input) -> "Book Flight")
                )
                .addStep(
                        Step.of(Checkpoint.of("BOOK_CAB"), (context, input) -> "Book Cab")
                )
                .addStep(
                        BranchStep.<String,String, Integer>of(
                                Checkpoint.of("CHECK_RETURN_TRANSPORT_AVAILABLE"),
                                (context, input) -> {
                                    if (new Random().nextBoolean()) {
                                        return new CheckpointWithOutput<>(
                                                Checkpoint.of("TRAIN_AVAILABLE"),
                                                123
                                        );
                                    }
                                    return new CheckpointWithOutput<>(
                                            Checkpoint.of("BUS_AVAILABLE"),
                                            456
                                    );
                                },
                                branchStepSubsequence -> {
                                    branchStepSubsequence
                                            .on(
                                                    Checkpoint.of("TRAIN_AVAILABLE"), input -> Sequence.begin()
                                                            .addStep(Step.of(
                                                                    Checkpoint.of("BOOK_TRAIN"),
                                                                    (context2, input2) -> "Book Train"
                                                            ))
                                            );
                                    branchStepSubsequence
                                            .on(
                                                    Checkpoint.of("BUS_AVAILABLE"), input -> Sequence.begin()
                                                            .addStep(Step.of(
                                                                    Checkpoint.of("BOOK_BUS"),
                                                                    (context2, input2) -> "Book Bus"
                                                            ))
                                            );

                                }
                        )
                );
        persistentFlowContext.registerSequence(sequence);
    }
}
