package Task_2_22;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) throws Exception {

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
        List<String> holidays = new ArrayList<>();
        holidays.add("01.01"); // Новогодние каникулы
        holidays.add("02.01"); // Новогодние каникулы
        holidays.add("03.01"); // Новогодние каникулы
        holidays.add("04.01"); // Новогодние каникулы
        holidays.add("05.01"); // Новогодние каникулы
        holidays.add("06.01"); // Новогодние каникулы
        holidays.add("07.01"); // Рождество Христово
        holidays.add("08.01"); // Новогодние каникулы
        holidays.add("23.02"); // День защитника Отечества
        holidays.add("08.03"); // Международный женский день
        holidays.add("01.05"); // Праздник Весны и Труда
        holidays.add("09.05"); // День Победы
        holidays.add("12.06"); // День России
        holidays.add("04.11"); // День народного единства

        int workDaysToAdd = 10;
        date = inputFormat.parse(inputDate);
        // Увеличение даты на рабочие дни
        Date resultDate = addWorkingDays(date, workDaysToAdd, holidays);
        System.out.println("Дата после увеличения на " + workDaysToAdd + " рабочих дней: " + inputFormat.format(resultDate));

        // Посчитать количество рабочих дней (субботы и воскресенья - выходные) между первой и второй датами введенными с консоли и вывести на экран
        System.out.print("Введите вторую дату в формате 31.12.2020: ");
        String secondInputDate = in.nextLine().trim();
        date = inputFormat.parse(inputDate);
        calendar.setTime(date);
        Calendar secondCalendar = Calendar.getInstance();
        Date secondDate = new Date();
        try {
            secondDate = inputFormat.parse(secondInputDate);
        } catch (Exception e) {
            System.out.println("Ошибка парсинга даты");
        }
        secondCalendar.setTime(secondDate);

        try {
            if(secondDate.before(date) || secondDate.equals(date)) {
                throw new Exception("Вторая дата должна быть позднее " + inputFormat.format(date));
            }
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        int days = 0;
        if (calendar.before(secondCalendar)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            while (calendar.before(secondCalendar)) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                String firstDateStr = inputFormat.format(calendar.getTime());
                boolean isHoliday = holidays.contains(firstDateStr);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY && !isHoliday) {
                    days++;
                }
            }
            System.out.println("Количество рабочих дней между введенными датами: " + days);
            in.close();
        }

    }

    private static Date addWorkingDays(Date date, int daysToAdd, List<String> holidays) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int workDaysAdded = 0;

        while (workDaysAdded < daysToAdd) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date currentDate = calendar.getTime();

            // Проверяем, является ли текущий день нерабочим праздничным днем
            String currentDateStr = sdf.format(currentDate);
            boolean isHoliday = holidays.contains(currentDateStr);

            // Проверяем, является ли текущий день субботой или воскресеньем
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY && !isHoliday) {
                workDaysAdded++;
            }
        }

        return calendar.getTime();
    }

}
