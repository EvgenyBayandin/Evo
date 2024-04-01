package Task_2_21;
import java.util.Scanner;

public class Task_4_2 {

    /*
     * Ввести строку /Это бяка? Нет это кака/
     * Заменить в строке все слова "кака" и "бяка" на "вырезано цензурой"
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: 'Это бяка? Нет это кака' ");
        String str = new String(in.nextLine()).trim();
//        // способ 1
//        str = str.replace("кака", "вырезано цензурой");
//        str = str.replace("бяка", "вырезано цензурой");
//        System.out.println(str);
        // способ 2
        str = str.replaceAll("кака|бяка", "вырезано цензурой");
        System.out.println(str);
        in.close();

    }
}
