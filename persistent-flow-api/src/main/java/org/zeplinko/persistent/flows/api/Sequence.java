package org.zeplinko.persistent.flows.api;

import org.zeplinko.persistent.flows.api.impl.SequenceImpl;

public interface Sequence<T> {
    static Sequence<Void> begin() {
        return new SequenceImpl<>();
    }

    <U> Sequence<U> addStep(Step<T, U> step);
}
