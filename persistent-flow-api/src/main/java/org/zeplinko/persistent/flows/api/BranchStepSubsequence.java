package org.zeplinko.persistent.flows.api;

import java.util.function.Function;
import java.util.function.Supplier;

public interface BranchStepSubsequence<U> {
    Sequence<U> on(Checkpoint checkpoint, Supplier<Sequence<U>> function);
}
