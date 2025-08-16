package org.zeplinko.persistent.flows.api;

public interface PersistentFlow {
    void initialise(PersistentFlowContext context);
}
