package com.github.begleyalan;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Alan on 25/03/2015.
 */
public class TraversableOnlyOnce {
    public static void main(String [] args){
        List<String> title = Arrays.asList("Java8", "in", "action");
        Stream stream = title.stream();
        stream.forEach(System.out::println);
        //A stream can only be traversed once.  The statement below throws a java.lang.IllegalStateException: stream has already been operated upon or closed.
        //stream.forEach(System.out::println);
    }
}
