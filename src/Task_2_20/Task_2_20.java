package Task_2_20;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Task_2_20 {
    public static void main(String[] args) {

        /*
         * Заполнить массив из 20 элементов случайными целыми значениями в диапазоне от 1 до 15 включительно
         * Вывести на экран содержимое массива
         *  Вывести на экран значения, которые встречаются в массиве больше одного раза, в формате, вида:
         *  "Число '3' встречается 2 раза"
         * "Число '5' встречается 3 раза" и т.д.
         */

        int[] array = new int[20];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(15) + 1;
        }

        for (int index : array) {
            System.out.print(index + " ");
        }
        System.out.print("\n");

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print("Число '" + entry.getKey() + "' встречается " + entry.getValue());
                System.out.println(entry.getValue() >= 5 ? " раз" : " раза");
            }
        }
    }
}
