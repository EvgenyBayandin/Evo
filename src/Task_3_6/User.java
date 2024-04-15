package Task_3_6;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Comparator;


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
    💡- Создать новую мапу HashMap<Integer, List<User>>(), которая будет в качестве ключа хранить возраст, а в качестве значения - список пользователей;
    💡- Циклически запросить у оператора ввести данные 5-ти пользователей и записать объекты, созданные при вводе, в HashMap.
    Причем, если ключ (возраст) в мапе уже существует, то добавлять объект очередного пользователя в список, лежащий в значении по ключу.
    Если ключ в мапе еще не существует, то создавать новый список, записывать туда юзера и класть этот список в мапу по этому ключу.
    💡- Запросить у пользователя ввести требуемый возраст и, если такой ключ есть в мапе, вывести на консоль пользователей из списка,
    полученного по ключу из мапы, отсортированных по имени.
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

        HashMap<Integer, List<User>> mapUsers = new HashMap<>();

        boolean isValidData;

        for (int i = 1; i <= 5; i++) {

            boolean isValidName = false;
            String name = "";
            while (!isValidName) {
                try {
                    System.out.println("Введите имя пользователя " + i + ": ");
                    name = in.nextLine().trim();
                    if (name != null && name.isEmpty()) {
                        System.out.println("Имя пользователя не может быть пустым. Введите имя пользователя" + i + ": ");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Некорректный ввод данных пользователя " + i + "!");
                }
                isValidName = true;
            }

            isValidData = false;
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
                    System.out.println("Введен некорректный возраст пользователя. Введите возраст пользователя " + i + ": ");
                }
            }
            User user = new User(name, age);
            List<User> users = mapUsers.getOrDefault(age, new ArrayList<>());
            users.add(user);
            mapUsers.put(age, users);
        }

        TreeMap<Integer, List<User>> sortedMap = new TreeMap<>(mapUsers);

        isValidData = false;
        while (!isValidData) {
            System.out.println("Введите требуемый возраст: ");
            String ageIn = in.nextLine().trim();
            try {
                int a = Integer.parseInt(ageIn);
                if(a <= 0 || a > 100) {
                    System.out.println("Укажите корректный возраст");
                    continue;
                }

                List<User> users = sortedMap.get(a);
                if (users != null && !users.isEmpty()) {
                    users.sort(Comparator.comparing(User::getName));
                    for (User user : users) {
                        System.out.println(user.toString());
                    }
                } else {
                    System.out.println("Пользователь с возрастом '" + a + "' не найден");
                }

                isValidData = true;
            } catch (NumberFormatException e) {
                System.out.println("Введен некорректный возраст. Введите требуемый возраст: ");
            }
        }
        in.close();
    }

    @Override
    public String toString(){
            return name + ", возраст " + age + " лет";
    }

}