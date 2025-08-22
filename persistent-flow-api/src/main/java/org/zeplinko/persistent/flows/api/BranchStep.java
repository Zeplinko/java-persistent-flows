package org.zeplinko.persistent.flows.api;

import java.util.function.BiConsumer;

public interface BranchStep<T, U> extends Step<T, U> {
    static <K extends Enum<K>, T, V, U> BranchStep<T, U> of(
            ThrowingBiFunction<PersistentFlowContext, T, CheckpointWithOutput<K, V>> function,
            BiConsumer<V, BranchStepSubsequence<K, U>> consumer
    ) {
        return new BranchStepImpl<>();
    }

}
