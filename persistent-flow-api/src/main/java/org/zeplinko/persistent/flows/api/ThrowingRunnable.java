package org.zeplinko.persistent.flows.api;

@FunctionalInterface
public interface ThrowingRunnable {
    void run() throws Exception;
}
