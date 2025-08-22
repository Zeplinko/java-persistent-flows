package org.zeplinko.persistent.flows.api;

import java.util.function.Function;

public interface BranchStepSubsequence<T, U> {
    Sequence<U> on(Checkpoint checkpoint, Function<T, Sequence<U>> function);
}
