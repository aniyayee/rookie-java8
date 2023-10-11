package com.rookie.c3;

import static com.rookie.c2.AppleInventory.inventory;
import static com.rookie.c2.AppleInventory.printList;

import com.rookie.c2.Apple;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author yayee
 */
public class Main {

    public static void main(String[] args) {
        // Use FunctionalInterface
        /* forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));
        List<Integer> l = map(Arrays.asList("lambda", "in", "action"), (String s) -> s.length());
        printList(l);
        Predicate<List<String>> listPredicate = (List<String> list) -> !list.isEmpty();
        System.out.println(listPredicate.test(Arrays.asList()));
        Supplier<Apple> appleSupplier = () -> new Apple(Color.RED, 100);
        System.out.println(appleSupplier.get());
        Consumer<Apple> appleConsumer = (Apple apple) -> System.out.println(apple.getWeight());
        appleConsumer.accept(appleSupplier.get());
        Function<String, Integer> stringIntegerFunction = (String s) -> s.length();
        System.out.println(stringIntegerFunction.apply("lambda"));
        IntBinaryOperator intBinaryOperator = (int a, int b) -> a * b;
        System.out.println(intBinaryOperator.applyAsInt(2, 4));
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println(evenNumbers.test(1000)); */

        // Compare weights
        inventory.sort(new AppleComparator());  // 1传递代码
        printList(inventory);
        inventory.sort(new Comparator<Apple>() {    // 2使用匿名类
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        printList(inventory);
        inventory.sort((Apple o1, Apple o2) -> o1.getWeight() - o2.getWeight());    // 3使用Lambda表达式
        inventory.sort((o1, o2) -> o1.getWeight() - o2.getWeight());
        inventory.sort(Comparator.comparing(apple -> apple.getWeight()));
        inventory.sort(Comparator.comparing(Apple::getWeight));     // 4使用方法引用
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
