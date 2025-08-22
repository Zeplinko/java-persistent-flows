package org.zeplinko.persistent.flows.api;

import java.util.function.Function;

public interface BranchStep<C extends Enum<C>, I, T, O> extends Step<I, O> {
    static <C extends Enum<C>, I, T, O> BranchStep<C, I, T, O> of(
            ThrowingBiFunction<PersistentFlowContext, I, CheckpointWithOutput<C, T>> function
    ) {
        return new BranchStepImpl<>();
    }

    BranchStep<C, I, T, O> on(EnumCheckpoint<C> checkpoint, Function<T, Sequence<O>> function);

}
