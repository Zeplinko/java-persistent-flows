package org.zeplinko.persistent.flows.api.impl;

import org.zeplinko.persistent.flows.api.Checkpoint;
import org.zeplinko.persistent.flows.api.PersistentFlowContext;
import org.zeplinko.persistent.flows.api.Step;
import org.zeplinko.persistent.flows.api.ThrowingBiFunction;

public class StepImpl<T, U> implements Step<T, U> {
    public StepImpl(
            Checkpoint checkpoint,
            ThrowingBiFunction<PersistentFlowContext, T, U> function
    ) {

    }
}
