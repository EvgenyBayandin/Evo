package Task_3_5;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
public class User {

    /*
    💡- Создать класс "User", содержащий две переменных:
    private String name;
    private Integer age;
    💡- Добавить в класс геттеры и сеттеры, присваивающие и возвращающие значения этих переменных
    💡- Добавить в класс метод: public String toString(), который возвращает строку вида: "Вася, возраст 25 лет",
    где "Вася" - значение переменной name, а 25 - значение переменной age.
    💡- Создать конструктор класса, принимающий на вход два значения и инициализирующий ими эти переменные
    в методе main главного класса:
    💡- Создать новый список ArrayList<User>();
    💡- Циклически запросить у оператора ввести данные 5-ти пользователей и записать объекты, созданные при вводе, в ArrayList<>
    💡- Вывести на консоль список пользователей (используя метод toString()), отсортированных по возрастанию возраста
    (сортировать, используя Collections.sort(), реализовав в нем Comparator, сравнивающий значения переменных age)
    */

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {

            boolean isValidName = false;
            String name = "";
            while (!isValidName) {
                try {

                    System.out.println("Введите имя пользователя " + i + ": ");
                    name = in.nextLine().trim();
                        if (name != null && name.isEmpty()) {
                            System.out.println("Имя пользователя " + i + " не может быть пустым. Повторите ввод.");
                            continue;
                        }
                } catch (Exception e) {
                    System.out.println("Некорректный ввод данных пользователя " + i + "!");
                }
                isValidName = true;
            }

            boolean isValidData = false;
            int age = 0;
            while (!isValidData) {
                System.out.println("Введите возраст пользователя " + i + ": ");
                String ageInput = in.nextLine().trim();
                try {
                    age = Integer.parseInt(ageInput);
                    if(age <= 0 || age > 100) {
                        System.out.println("Укажите корректный возраст");
                        continue;
                    }
                    isValidData = true;
                } catch (NumberFormatException e) {
                    System.out.println("Введен некорректный возраст пользователя " + i + ". Повторите ввод.");
                }
            }
            User user = new User(name, age);
            users.add(user);
        }
        in.close();

        Collections.sort(users, new myComparator());
        for (User user : users) {
            System.out.println(user.toString());
        }

    }

    public String toString(){
        return name + ", возраст " + age + " лет";
    }

}

class myComparator implements Comparator<User> {
    public int compare(User user1, User user2) {
        return user1.getAge().compareTo(user2.getAge());

    }
}