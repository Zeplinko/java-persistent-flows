package org.zeplinko.persistent.flows.api;

public class BranchStepImpl<T, U> implements BranchStep<T, U> {


    public <T,U, V> BranchStepImpl(
            Checkpoint checkpoint,
            ThrowingBiFunction<PersistentFlowContext, T, CheckpointWithOutput<V>> function
    ) {

    }
}
