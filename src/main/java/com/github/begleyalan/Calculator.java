package com.github.begleyalan;

/**
 * Created by abegley on 31/07/2014.
 */
public class Calculator {
    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op){
        return op.operation(a,b);
    }

    public static void main(String... args){
        Calculator calculatorApp = new Calculator();
        IntegerMath addition = (a,b) -> a+b;
        IntegerMath subtraction = (a,b) -> a-b;
        System.out.println("40 + 2 = " + calculatorApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + calculatorApp.operateBinary(20, 10, subtraction));
    }

    //Syntax of Lambda expression

        //1. A comma-separated list of formal parameters in parentheses.
        //You can omit the data type of the parameters in a lambda expression.  You can also omit
        //the parentheses if there is only one parameter.  For example
            // p -> p.getGender() == Person.Sex.Male
            //                      && p.getAge() >= 18
            //                      && p.getAge() <= 25

}
