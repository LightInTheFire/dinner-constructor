package ru.practicum.dinner;

import java.util.*;

public class DinnerConstructor {

    private final Random random;
    private final Map<String, ArrayList<String>> dishInfo;

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

    public boolean isTypeValid(String type) {
        return dishInfo.containsKey(type);
    }

    public Set<String> getDishTypes() {
        return dishInfo.keySet();
    }

    public List<String> generateDishCombo(List<String> dishTypes) {
        List<String> combo = new ArrayList<>();


        for (String dishType : dishTypes) {
            int randomIndexBound = dishInfo.get(dishType).size();
            int randomIndex = random.nextInt(randomIndexBound);
            String dishName = dishInfo.get(dishType).get(randomIndex);
            combo.add(dishName);
        }

        return combo;
    }
}
