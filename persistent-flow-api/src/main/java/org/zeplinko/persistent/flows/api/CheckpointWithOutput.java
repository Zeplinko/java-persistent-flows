package org.zeplinko.persistent.flows.api;

public class CheckpointWithOutput<K extends Enum<K>, T> {
    private final EnumCheckpoint<K> checkpoint;
    private final T data;

    public CheckpointWithOutput(EnumCheckpoint<K> checkpoint, T data) {
        this.checkpoint = checkpoint;
        this.data = data;
    }
}
