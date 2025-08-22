package org.zeplinko.persistent.flows.api;

public class CheckpointWithOutput<C extends Enum<C>, T> {
    private final EnumCheckpoint<C> checkpoint;
    private final T data;

    public CheckpointWithOutput(EnumCheckpoint<C> checkpoint, T data) {
        this.checkpoint = checkpoint;
        this.data = data;
    }
}
