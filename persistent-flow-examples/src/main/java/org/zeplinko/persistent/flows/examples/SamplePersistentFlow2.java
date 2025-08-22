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
                        BranchStep.of(
                                (context, input) -> {
                                    if (new Random().nextBoolean()) {
                                        return Sequence.begin()
                                                .addStep(Step.of(
                                                        Checkpoint.of("BOOK_TRAIN"),
                                                        (context2, input2) -> "Book Train"
                                                ));
                                    }
                                    return Sequence.begin()
                                            .addStep(Step.of(
                                                    Checkpoint.of("BOOK_BUS"),
                                                    (context2, input2) -> "Book Bus"
                                            ));
                                }
                        )
                );
        persistentFlowContext.registerSequence(sequence);
    }
}
