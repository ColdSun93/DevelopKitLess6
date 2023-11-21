package ru.coldsun;

import java.util.HashMap;
import java.util.Map;


public class Main {
    static int quantityIteration = 1000;

    public static void main(String[] args) {
        int countWinner = 0;
        int countLoser = 0;
        for (int i = 0; i < processingGame().size(); i++) {
            if (processingGame().get(i + 1)) {
                countWinner++;
            } else {
                countLoser++;
            }
        }
        System.out.println("Выигрышных комбинаций: " + countWinner + "\nПроигрышных комбинаций: " + countLoser);

        double percentWinner = (double) (countWinner * 100) / quantityIteration;
        double percentLoser = (double) (countLoser * 100) / quantityIteration;
        System.out.println("% выигрышных комбинаций: " + percentWinner + "\n% проигрышных комбинаций: " + percentLoser);
    }

    /**
     * Метод получения парадокс Монти Холла
     * смена варианты при открытии одной двери
     * @return коллекция HashMap результатов комбинаций
     */
    public static Map<Integer, Boolean> processingGame() {

        Map<Integer, Boolean> result = new HashMap<>();

        for (int i = 0; i < quantityIteration; i++) {

            int car;
            car = (int) (Math.random() * 3);
            int player = 0; //по умолчанию выбираем первую дверь, так как вероятность при первом выборе одинаковая
            int goat;

            if (car == 1) {
                goat = 2;
            } else
                goat = 1;

            // всегда меняем решения при выборе из двух оставшихся вариантов
            if (goat == 1)
                player = 2;
            else
                player = 1;

            // провеяем результат игры
            if (player == car)
                result.put(i + 1, true);
            else
                result.put(i + 1, false);
        }

        return result;
    }
}
