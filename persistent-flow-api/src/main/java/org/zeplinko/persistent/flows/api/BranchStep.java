package org.zeplinko.persistent.flows.api;

public interface BranchStep<T, U> extends Step<T, U> {
    static <T, U> BranchStep<T, U> of(
            ThrowingBiFunction<PersistentFlowContext, T, Sequence<U>> function
    ) {
        return new BranchStepImpl<>();
    }

}
