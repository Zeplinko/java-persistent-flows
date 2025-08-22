package org.zeplinko.persistent.flows.api;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface BranchStep<T, U> extends Step<T, U> {
    static <T, V, U> BranchStep<T, U> of(
            ThrowingBiFunction<PersistentFlowContext, T, CheckpointWithOutput<V>> function,
            BiConsumer<V, BranchStepSubsequence<U>> consumer
    ) {
        return new BranchStepImpl<>();
    }

}
