package org.zeplinko.persistent.flows.api;

import org.zeplinko.persistent.flows.api.impl.StepImpl;

public interface Step<T,U> {
    static <T,U> Step<T, U> of(Checkpoint checkpoint, ThrowingBiFunction<PersistentFlowContext, T, U> function) {
        return new StepImpl<>(checkpoint, function);
    }
}
