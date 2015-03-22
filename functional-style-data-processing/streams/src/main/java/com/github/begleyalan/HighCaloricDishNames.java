package com.github.begleyalan;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by alan on 3/22/15.
 */
public class HighCaloricDishNames {

    public List<String> getThreeHighCaloricDishNames(List<Dish> menu) {
        return menu.stream()
                    .filter(dish -> dish.getCalories() > 300)
                    .map(Dish::getName)
                    .limit(3)
                    .collect(toList());
    }
}
