package org.zeplinko.persistent.flows.api;

@FunctionalInterface
public interface ThrowingBiFunction<T,U,V> {
    V apply(T t, U u) throws Exception;
}
