package com.github.begleyalan.chp02;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abegley on 27/08/2014.
 */
public class PrettyPrintApple {
    public static void main(String ... args){
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(120, "green"), new Apple(150, "red"));
        prettyPrintApple(inventory, new FancyFormatter());
        prettyPrintApple(inventory, new SimpleFormatter());
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter ){
           for(Apple apple: inventory){
               String output = formatter.accept(apple);
               System.out.println(output);
           }
    }

     static class Apple {
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
    interface AppleFormatter{
        String accept(Apple apple);
    }

    static class FancyFormatter implements AppleFormatter {

        @Override
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " + apple.getColour() + " apple";
        }
    }

    static class SimpleFormatter implements AppleFormatter {

        @Override
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }

}
