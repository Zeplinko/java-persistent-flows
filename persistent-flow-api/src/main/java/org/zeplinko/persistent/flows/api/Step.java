package org.zeplinko.persistent.flows.api;

import org.zeplinko.persistent.flows.api.impl.StepImpl;

public interface Step<I,O> {
    static <I, O> Step<I, O> of(Checkpoint checkpoint, ThrowingBiFunction<PersistentFlowContext, I, O> function) {
        return new StepImpl<>(checkpoint, function);
    }
}
