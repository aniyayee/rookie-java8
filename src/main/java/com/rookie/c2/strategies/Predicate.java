package com.rookie.c2.strategies;

/**
 * @author yayee
 */
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);
}
