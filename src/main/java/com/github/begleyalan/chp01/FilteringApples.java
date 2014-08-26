package com.github.begleyalan.chp01;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Alan on 26/08/2014.
 * Example taken from Java 8 in Action, chp01
 */
public class FilteringApples {

    public static void main(String ... args){
            List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                                                new Apple(155, "green"),
                                                new Apple(120, "red"));

            List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
            System.out.println(greenApples);

            List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
            System.out.println(heavyApples);

            List<Apple> greenApples2 = filterApples(inventory, (Apple a)-> "green".equals(a.getColour()));
            System.out.println(greenApples2);

            List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
            System.out.println(heavyApples2);

            List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColour()));
            System.out.println(weirdApples);
    }

    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColour());
    }

    private static class Apple {
        private final int weight ;
        private final String colour;

        public Apple(int weight, String colour) {
            this.weight = weight;
            this.colour = colour;
        }

        public String getColour() {
            return colour;
        }

        public Integer getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", colour='" + colour + '\'' +
                    '}';
        }
    }
}
