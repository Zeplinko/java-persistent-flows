package org.zeplinko.persistent.flows.api;

public interface Checkpoint {
    static Checkpoint of(String name) {
        return new Checkpoint() {
        };
    }

    static <T extends Enum<T>> EnumCheckpoint<T> of(T t) {
        return null;
    }
}
