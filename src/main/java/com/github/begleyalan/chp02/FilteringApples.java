package com.github.begleyalan.chp02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alan on 26/08/2014.
 */
public class FilteringApples {
    public static void main(String ...args){
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        List<Apple> greenApples = filterApplesByColour(inventory, "green");
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColour(inventory, "red");
        System.out.println(redApples);

        List<Apple> greenApples2 = filter(inventory, new AppleColourPredicate());
        System.out.println(greenApples2);

        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
        System.out.println(heavyApples);

        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return a.getColour().equals("red");
            }
        });

        System.out.println(redApples2);


    }

    private static List<Apple> filter(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterApplesByColour(List<Apple> inventory, String colour) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(apple.getColour().equals(colour)){
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColour() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    interface ApplePredicate{
        public boolean test(Apple a);
    }
    static class AppleColourPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColour());
        }
    }

   static class AppleWeightPredicate implements ApplePredicate {
       @Override
       public boolean test(Apple apple) {
           return apple.getWeight() > 150;
       }
   }

    static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "red".equals(apple.getColour()) && apple.getWeight() > 150;
        }
    }
}
