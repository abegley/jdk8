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


    }

    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> isGreenApple) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(isGreenApple(apple)){
                result.add(apple);
                System.out.println(apple);
            }
        }
        return result;
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
