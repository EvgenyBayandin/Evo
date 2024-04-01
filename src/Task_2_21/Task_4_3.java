package Task_2_21;
import java.util.Scanner;

public class Task_4_3 {

    /*
    * 4.3 Ввести строку с датой формата: 31.12.2020
    * Преобразовать строку даты в формат: 2020-12-31
    */

    public static void main(String[] args) {

        System.out.print("Введите строку с датой формата 31.12.2020: ");
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        String[] date_array = date.split("\\.");
        String year = date_array[2];
        String month = date_array[1];
        String day = date_array[0];
        String new_date = year + "-" + month + "-" + day;
        System.out.println("Преобразованная дата: " + new_date);
        in.close();

    }
}
