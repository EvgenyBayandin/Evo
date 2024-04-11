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
        String inputDate = "";
        Date date = null;
        boolean isValidDate = false;
        while (!isValidDate) {
            try {
                System.out.print("Введите дату в формате dd.MM.yyyy: ");
                inputDate = in.nextLine().trim();
                date = inputFormat.parse(inputDate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int year = cal.get(Calendar.YEAR);
                if (year < 2013 || year > 2099) {
                    System.out.println("Некорректный год в введенной дате. Пожалуйста, введите дату с годом между 2013 и 2099.");
                    continue;
                }
                isValidDate = true;
            } catch (Exception e) {
                System.out.println("Некорректный формат даты. Пожалуйста, введите дату в формате 31.12.2024.");
            }
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
        System.out.println("Дата после сдвига на начало года: " + firstDayOfYear);


        // Увеличение введенной даты на 10 рабочих дней
        // Создаем справочник праздничных нерабочих дней, начиная с 2013 по настоящее время в формате "dd.MM"
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
        String secondInputDate = "";
        Date secondDate = null;
        Calendar cal = new GregorianCalendar();
        isValidDate = false;
        while (!isValidDate) {
            try {
                System.out.print("Введите вторую дату в формате dd.MM.yyyy: ");
                secondInputDate = in.nextLine().trim();
                secondDate = inputFormat.parse(secondInputDate);
                cal = Calendar.getInstance();
                cal.setTime(secondDate);
                int year = cal.get(Calendar.YEAR);
                if (secondDate.before(date) || secondDate.equals(date)) {
                    System.out.println("Введенная дата должна быть позднее " + inputFormat.format(date));
                    continue;
                } else if (year < 2013 || year > 2099) {
                    System.out.println("Некорректный год в введенной дате. Пожалуйста, введите дату с годом между 2013 и 2099.");
                    continue;
                }
                isValidDate = true;
            } catch (Exception e) {
                System.out.println("Некорректный формат даты. Пожалуйста, введите дату в формате 31.12.2024.");
            }
        }
        // Подсчет рабочих дней между двумя датами
        int workDaysBetween = countWorkingDays(date, secondDate, holidays);
        System.out.println("Количество рабочих дней между введенными датами: " + workDaysBetween);
        in.close();
    }


    // Метод для добавления рабочих дней
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

            // Проверяем, является ли текущий день субботой, воскресеньем или праздником
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY && !isHoliday) {
                workDaysAdded++;
            }
        }
        return calendar.getTime();
    }


    // Метод для подсчета рабочих дней между двумя датами
    private static int countWorkingDays(Date startDate, Date endDate, List<String> holidays) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int workDays = 0;
        if (!calendar.getTime().after(endDate)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            while (calendar.getTime().before(endDate)) {
                Date currentDate = calendar.getTime();

                // Проверяем, является ли текущий день нерабочим праздничным днем
                String currentDateStr = sdf.format(currentDate);
                boolean isHoliday = holidays.contains(currentDateStr);

                // Проверяем, является ли текущий день субботой, воскресеньем или праздником
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY && !isHoliday) {
                    workDays++;
                }
                calendar.add(Calendar.DAY_OF_YEAR, 1);
            }
        }
        return workDays;
    }

}
