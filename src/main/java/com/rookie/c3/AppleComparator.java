package com.rookie.c3;

import com.rookie.c2.Apple;
import java.util.Comparator;

/**
 * @author yayee
 */
public class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight() - a2.getWeight();
    }
}
