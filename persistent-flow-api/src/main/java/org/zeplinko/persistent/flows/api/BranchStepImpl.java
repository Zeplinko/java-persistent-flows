package org.zeplinko.persistent.flows.api;

import java.util.function.Function;

public class BranchStepImpl<K extends Enum<K>, T, V, U>  implements BranchStep<K, T, V, U>  {


    public BranchStepImpl(
    ) {

    }

    @Override
    public BranchStep<K, T, V, U> on(EnumCheckpoint<K> checkpoint, Function<V, Sequence<U>> function) {
        return null;
    }
}
