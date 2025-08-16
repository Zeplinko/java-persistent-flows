package org.zeplinko.persistent.flows.api;

public interface Checkpoint {
    static Checkpoint of(String name) {
        return new Checkpoint() {
        };
    }
}
