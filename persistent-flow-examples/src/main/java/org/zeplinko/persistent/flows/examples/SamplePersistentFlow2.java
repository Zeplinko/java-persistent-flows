package org.zeplinko.persistent.flows.examples;

import org.zeplinko.persistent.flows.api.*;

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
                        Step.of(Checkpoint.of("BOOK_RETURN_FLIGHT"), (context, input) -> "Book return flight")
                );
        persistentFlowContext.registerSequence(sequence);
    }
}
