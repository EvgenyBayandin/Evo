package Task_3_4;
import java.util.Scanner;

public class User {

    /*
    * 💡💡- Создать класс "User", содержащий две переменных:
    * private String name;
    * private Integer age;
    *
    * 💡- Добавить в класс геттеры и сеттеры, присваивающие и возвращающие значения этих переменных
    * 💡- Добавить в класс метод: public String toString(), который возвращает строку вида: "Вася, возраст 25 лет", где
    * "Вася" - значение переменной name, а 25 - значение переменной age.
    *
    * 💡- Создать конструктор класса, принимающий на вход два значения и инициализирующий ими эти переменные в методе main главного класса:
    * 💡- Последовательно запросить у пользователя ввести строку с именем, затем число возраста, сохранить их в соответствующих переменных
    * 💡- Создать объект класса User, передав в его конструктор эти две переменных в качестве значений, которые он может принять
    * 💡- Еще раз запросить у оператора имя и возраст другого юзера
    * 💡- Создать второй объект класс User, передав в его конструктор эти две переменных в качестве значений, которые он может принять
    * 💡- Вывести в консоль значение, которое возвращает toString() у объекта с наименьшим age
    */

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
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

        User userOne = new User();
        User userTwo = new User();

        boolean isValidName = false;
        boolean isValidData = false;

        while (!isValidName) {
            try {
                System.out.print("Введите имя первого пользователя: ");
                String name = in.nextLine().trim();
                    if (name != null && name.isEmpty()) {
                        System.out.println("Имя не может быть пустым");
                        continue;
                    }
//                    if (!isValidName(name)) {
//                        System.out.println("Имя должно содержать только буквы");
//                        continue;
//                    }
                        userOne.setName(name);
                        isValidName = true;
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных!");
            }
        }


        while (!isValidData) {
            try {
                System.out.print("Введите возраст первого пользователя: ");
                int age = Integer.parseInt(in.nextLine().trim());
                if(age <= 0 || age > 100) {
                    System.out.println("Укажите корректный возраст");
                    continue;
                }
                userOne.setAge(age);
                isValidData = true;
            } catch (Exception exception){
                System.out.println("Укажите возраст в годах, в виде целого числа");
            }
        }

        isValidName = false;
        while (!isValidName) {
            try {
                System.out.print("Введите имя второго пользователя: ");
                String name = in.nextLine().trim();
                if (name != null && name.isEmpty()) {
                    System.out.println("Имя не может быть пустым");
                    continue;
                }
//                if (!isValidName(name)) {
//                    System.out.println("Имя должно содержать только буквы");
//                    continue;
//                }
                userTwo.setName(name);
                isValidName = true;
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных!");
            }
        }

        isValidData = false;
        while (!isValidData) {
            try {
                System.out.print("Введите возраст второго пользователя: ");
                int age = Integer.parseInt(in.nextLine().trim());
                if(age <= 0 || age > 100) {
                    throw new Exception("кажите корректный возраст");
                }
                userTwo.setAge(age);
                isValidData = true;
            } catch (Exception exception){
                System.out.println("Укажите возраст в годах, в виде целого числа");
            }
        }
        in.close();

        if(userTwo.getAge() > userOne.getAge()){
            System.out.println(userOne.toString());
        } else {
            System.out.println(userTwo.toString());
        }

    }


//    private static boolean isValidName(String name) {
//        return !name.isEmpty() && name.matches("^[a-zA-Zа-яА-Я ]+$");
//    }

    public String toString(){
        return name + ", возраст " + age + " лет";
    }
}
