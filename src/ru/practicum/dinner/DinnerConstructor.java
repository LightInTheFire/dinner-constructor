package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private final Random random;
    private final HashMap<String, ArrayList<String>> dishInfo;

    public DinnerConstructor(Random random) {
        this.random = random;
        this.dishInfo = new HashMap<>();
    }


    public void addNewDish(String dishType, String dishName) {

        if (dishInfo.containsKey(dishType)) {
            dishInfo.get(dishType)
                    .add(dishName);
        } else {
            ArrayList<String> newDishTypeList = new ArrayList<>();
            newDishTypeList.add(dishName);
            dishInfo.put(dishType, newDishTypeList);
        }

        System.out.printf("Добавлено блюдо %s для типа %s%n", dishName, dishType);
    }

    public HashMap<String, ArrayList<String>> generateDishCombo(int numberOfCombos, ArrayList<String> dishTypes) {

        return dishInfo;
    }
}
