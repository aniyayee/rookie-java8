package com.rookie.c2.strategies.formatter;

import com.rookie.c2.Apple;

/**
 * @author yayee
 */
public class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
