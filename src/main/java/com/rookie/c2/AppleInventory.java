package com.rookie.c2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yayee
 */
public class AppleInventory {

    public static List<Apple> inventory = new ArrayList<>();

    static {
        Apple apple1 = new Apple(Color.RED, 120);
        Apple apple2 = new Apple(Color.RED, 150);
        Apple apple3 = new Apple(Color.RED, 180);
        Apple apple4 = new Apple(Color.GREEN, 70);
        Apple apple5 = new Apple(Color.GREEN, 60);
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);
        inventory.add(apple4);
        inventory.add(apple5);
    }

    public static <T> void printList(List<T> list) {
        for (T e : list) {
            System.out.println("T = " + e);
        }
    }
}
