package com.rookie.c4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yayee
 */
public class Main {

    public static void main(String[] args) {
        // stream
        /* List<String> threeHighCaloricDishNames = Store.menu.stream()
            .filter(dish -> dish.getCalories() > 300)
            .map(Dish::getName)
            .limit(3)
            .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames); */

        // 只能遍历一次
        List<String> title = Arrays.asList("Modern", "Java", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        // s.forEach(System.out::println); // stream has already been operated upon or closed

        // 外部迭代
        List<String> names1 = new ArrayList<>();
        Iterator<Dish> iterator1 = Store.menu.iterator();
        while (iterator1.hasNext()) {
            Dish dish = iterator1.next();
            names1.add(dish.getName());
        }
        // 内部迭代
        List<String> names2 = Store.menu.stream()
            .map(Dish::getName)
            .collect(Collectors.toList());

        // 外部迭代
        List<String> highCaloricDishes1 = new ArrayList<>();
        Iterator<Dish> iterator2 = Store.menu.iterator();
        while (iterator2.hasNext()) {
            Dish dish = iterator2.next();
            if (dish.getCalories() > 300) {
                highCaloricDishes1.add(dish.getName());
            }
        }
        // 内部迭代
        List<String> highCaloricDishes2 = Store.menu.stream()
            .filter(dish -> dish.getCalories() > 300)
            .map(dish -> dish.getName())
            .collect(Collectors.toList());
    }
}
