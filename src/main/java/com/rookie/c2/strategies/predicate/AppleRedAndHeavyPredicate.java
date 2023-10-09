package com.rookie.c2.strategies.predicate;

import com.rookie.c2.Apple;
import com.rookie.c2.Color;

/**
 * @author yayee
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
