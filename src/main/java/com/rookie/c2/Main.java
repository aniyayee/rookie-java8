package com.rookie.c2;

import com.rookie.c2.strategies.formatter.AppleFormatter;
import com.rookie.c2.strategies.predicate.ApplePredicate;
import java.util.ArrayList;
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
        List<Apple> result = filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        printList(result);
        /* prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter()); */
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

    private static void printList(List<Apple> apples) {
        for (Apple apple : apples) {
            System.out.println("apple = " + apple);
        }
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }
}
