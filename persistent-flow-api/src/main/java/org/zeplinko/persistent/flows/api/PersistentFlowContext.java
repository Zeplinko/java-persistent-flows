package org.zeplinko.persistent.flows.api;

import java.util.List;

public interface PersistentFlowContext {
    void register(Checkpoint triggerCheckpoint, List<Checkpoint> targetCheckpoint, ThrowingRunnable runnable);
}
