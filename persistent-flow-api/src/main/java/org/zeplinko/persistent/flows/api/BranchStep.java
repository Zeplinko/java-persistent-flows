package org.zeplinko.persistent.flows.api;

import org.zeplinko.persistent.flows.api.impl.StepImpl;

import java.util.function.Consumer;

public interface BranchStep<T, U> extends Step<T,U> {
    static <T,U,V> BranchStep<T, U> of(Checkpoint checkpoint,
            ThrowingBiFunction<PersistentFlowContext, T, CheckpointWithOutput<V>> function,
            Consumer<BranchStepSubsequence<V, U>> subsequenceRegisterer
    ) {
        return new BranchStepImpl<>(checkpoint, function);
    }


}
