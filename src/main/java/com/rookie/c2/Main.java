package com.rookie.c2;

import com.rookie.c2.strategies.Predicate;
import com.rookie.c2.strategies.formatter.AppleFormatter;
import com.rookie.c2.strategies.predicate.ApplePredicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yayee
 */
public class Main {

    static List<Apple> inventory = new ArrayList<>();

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

    public static void main(String[] args) {
        /* List<Apple> apples = filterApples(inventory, new AppleRedAndHeavyPredicate());
        printList(apples); */

        // 匿名内部类
        /* List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });
        printList(redApples); */

        // Lambda
        /* List<Apple> result = filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        printList(result); */

        /* prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter()); */

        // 泛型
        List<Apple> redApples = filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        printList(redApples);
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> integers = filter(numbers, (Integer i) -> i % 2 == 0);
        printList(integers);
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static <T> void printList(List<T> list) {
        for (T e : list) {
            System.out.println("T = " + e);
        }
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
