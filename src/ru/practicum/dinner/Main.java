package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final String COMMAND_ADD_NEW_DISH = "1";
    public static final String COMMAND_GENERATE_DISH_COMBINATION = "2";
    public static final String COMMAND_EXIT = "3";

    public static final Scanner scanner = new Scanner(System.in);
    public static final DinnerConstructor dinnerConstructor = new DinnerConstructor(new Random());

    public static void main(String[] args) {

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case COMMAND_ADD_NEW_DISH -> addNewDish();
                case COMMAND_GENERATE_DISH_COMBINATION -> generateDishCombo();
                case COMMAND_EXIT -> {
                    System.out.println("Выход из приложения");
                    return;
                }
                default -> System.out.println("Такой командый не существует!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine().trim();

        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();

        dinnerConstructor.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine(); //flush buffer

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter)." +
                " Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        ArrayList<String> dishTypes = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            dishTypes.add(nextItem);
            nextItem = scanner.nextLine();
        }

        for (int i = 1; i <= numberOfCombos; i++) {
            System.out.printf("Комбо %d%n", i);
            ArrayList<String> combo = dinnerConstructor.generateDishCombo(dishTypes);
            System.out.println(combo);
        }

    }
}
