package Task_2_18;
import java.util.Scanner;
public class Task_2_18 {

    /*
     * Создать проект с главным классом (содержащим метод "main")
     * Вывести на консоль фразу: "Как тебя зовут?"
     * Считать ответ пользователя
     * Вывести пользователю строку: "Привет, <введенное имя>!"
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Как тебя зовут? ");
        String name = in.nextLine().trim();
        System.out.println("Привет, " + name + "!");

    }
}
