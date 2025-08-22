package org.zeplinko.persistent.flows.api;

public interface EnumCheckpoint<T extends Enum<T>> extends Checkpoint {
     static <T extends Enum<T>> EnumCheckpoint<T> of(T t) {
        return null;
    }
}
