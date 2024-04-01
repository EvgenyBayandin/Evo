package Task_2_21;
import java.util.Scanner;
public class Task_4_1 {

    /*
    * 4.1 Ввести с консоли строку, сохранить ее в строковой переменной /мама, мамонт, матрас/
    * Ввести с консоли подстроку, сохранить ее во второй строковой переменной /ма/
    * Подсчитать сколько раз подстрока встречается в строке и вывести это значение на экран.
    */

    public static void main(String[] args) {

        // 4.1
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = new String(in.nextLine()).trim();
        System.out.println("Введите подстроку: ");
        String sub = new String(in.nextLine()).trim();
        String [] subs = str.split(sub);
        System.out.println("Подстрока " + "'" + sub + "'" + " встречается " + (subs.length -1) + " раза");
        in.close();

    }
}
