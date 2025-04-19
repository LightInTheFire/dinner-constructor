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

    public ArrayList<String> generateDishCombo(ArrayList<String> dishTypes) {
        ArrayList<String> combo = new ArrayList<>();


        for (String dishType : dishTypes) {
            int randomIndexBound = dishInfo.get(dishType).size();
            int randomIndex = random.nextInt(randomIndexBound);
            String dishName = dishInfo.get(dishType).get(randomIndex);
            combo.add(dishName);
        }

        return combo;
    }
}
