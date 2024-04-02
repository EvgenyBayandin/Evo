package Task_2_22;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Task_5 {

    /*
    * Ввести с консоли дату в формата: 31.12.2020, сохранить ее в переменной класса Date (преобразовав введенную строку
    * с использованием SimpleDateFormat)
    *
    * Увеличить дату на 45 дней и вывести на экран
    *
    * Сдвинуть дату на начало года и вывести на экран
    *
    * Увеличить дату на 10 рабочих дней (считаем субботы и воскресенья выходными) и вывести на экран
    *
    * Ввести с консоли вторую дату в том же формате и сохранить ее в другой переменной класса Date
    *
    * Посчитать количество рабочих дней (субботы и воскресенья - выходные) между первой и второй датами введенными с
    * консоли и вывести на экран
    */

    public static void main(String[] args) {

        // устанавливаем формат даты
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");

        //Ввод первой даты и преобразование ее в строку
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату в формате 31.12.2020: ");
        String inputDate = in.nextLine().trim();
        Date date = new Date();
        try {
            date = inputFormat.parse(inputDate);
        } catch (Exception e) {
            System.out.println("Ошибка парсинга даты");
        }

        // Увеличение введенной даты на 45 календарных дней
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 45);
        String newDateStr = inputFormat.format(calendar.getTime());
        System.out.println("Дата после увеличения на 45 дней: " + newDateStr);
        try {
            date = inputFormat.parse(newDateStr);
            calendar.setTime(date);
        }catch (Exception e) {
            System.out.println("Ошибка парсинга даты");
        }

        // Сдвигаем увеличенную на 45 календарных дней дату на начало года
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        String firstDayOfYear = inputFormat.format(calendar.getTime());
        System.out.println("Дата сдвинута на начало года: " + firstDayOfYear);

        // Увеличение сдвинутой на начало года даты на 10 рабочих дней
        int workDays = 0;
        while (workDays < 10) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workDays++;
            }
        }
        String addedWorkingsDays = inputFormat.format(calendar.getTime());
        System.out.println("Дата после увеличения на 10 рабочих дней: " + addedWorkingsDays);

        // Ввод первой и второй дат и подсчет количества рабочих дней между ними
        System.out.print("Введите первую дату в формате 31.12.2020: ");
        String firstInputDate = in.nextLine().trim();
        Calendar firstCalendar = Calendar.getInstance();
        Date firstDate = new Date();
        try {
            firstDate = inputFormat.parse(firstInputDate);
        } catch (Exception e) {
            System.out.println("Ошибка парсинга даты");
        }
        firstCalendar.setTime(firstDate);

        System.out.print("Введите вторую дату в формате 31.12.2020: ");
        String secondInputDate = in.nextLine().trim();
        Calendar secondCalendar = Calendar.getInstance();
        Date secondDate = new Date();
        try {
            secondDate = inputFormat.parse(secondInputDate);
        } catch (Exception e) {
            System.out.println("Ошибка парсинга даты");
        }
        secondCalendar.setTime(secondDate);

        int days = 0;
        if (!firstCalendar.after(secondCalendar)) {
            firstCalendar.add(Calendar.DAY_OF_MONTH, 1);
            while (firstCalendar.before(secondCalendar)) {
                firstCalendar.add(Calendar.DAY_OF_MONTH, 1);
                int dayOfWeek = firstCalendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    days++;
                }
            }
        }
        System.out.println("Количество рабочих дней между введенными датами: " + days);
        in.close();
    }

}
