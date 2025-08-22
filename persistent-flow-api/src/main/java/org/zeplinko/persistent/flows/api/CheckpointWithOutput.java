package org.zeplinko.persistent.flows.api;

public class CheckpointWithOutput<T> {
    private final Checkpoint checkpoint;
    private final T data;

    public CheckpointWithOutput(Checkpoint checkpoint, T data) {
        this.checkpoint = checkpoint;
        this.data = data;
    }
}
