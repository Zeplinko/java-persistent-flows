package org.zeplinko.persistent.flows.api.impl;

import org.zeplinko.persistent.flows.api.Sequence;
import org.zeplinko.persistent.flows.api.Step;

public class SequenceImpl<T> implements Sequence<T> {
    @Override
    public <U> Sequence<U> addStep(Step<T, U> step) {
        return null;
    }
}
