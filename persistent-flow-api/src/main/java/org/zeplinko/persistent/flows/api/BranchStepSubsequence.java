package org.zeplinko.persistent.flows.api;

import java.util.function.Function;
import java.util.function.Supplier;

public interface BranchStepSubsequence<K extends Enum<K>, U> {
    Sequence<U> on(EnumCheckpoint<K> checkpoint, Supplier<Sequence<U>> function);
}
