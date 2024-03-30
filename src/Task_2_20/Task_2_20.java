package Task_2_20;

import java.util.Random;

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

        for (int index : array) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == index) {
                    count++;
                }
            }
            if (count > 1) {
                System.out.println("Число " + index + " встречается " + count + " раза");

            }
        }
    }
}
