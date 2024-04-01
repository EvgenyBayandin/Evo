package Task_2_21;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Task_4_4 {

    /*
    * 4.3 Ввести строку с датой формата: 31.12.2020. Преобразовать строку даты в формат: 2020-12-31
    * 4.4 Сделать задание 4.3. с использованием классов Date и SimpleDateFormat и их соответствующих методов
    */

    public static void main(String[] args) {

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату в формате 31.12.2020: ");
        String inputDate = in.nextLine();

        Date date;
        try {
            date = inputFormat.parse(inputDate);
            System.out.println(outputFormat.format(date));
            in.close();
        } catch (Exception e) {
            System.out.println("Ошибка парсинга даты");
        }
    }
}
