package ru.geekbrains.java1.dz4;

/**
 * Created by олег on 25.01.2017.
 */
class Employee {
    String fullName;
    String position;
    String email;
    Long phoneNumber;
    int salary;
    int age;

    Employee(String fullName, String position, String email, Long phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void print() {
        System.out.println(fullName);
        System.out.println(position);
        System.out.println(email);
        System.out.println(phoneNumber);
        System.out.println(salary);
        System.out.println(age);
    }
}

class EmployeeDemo {
    public static void main(String[] args) {
        Employee[] array = new Employee[5];
        array[0] = new Employee("Ivanov Ivan", "manager", "ivanovivan@gmail.com", 89119119191L, 100500, 35);
        array[1] = new Employee("Sidorov Sidor", "manager", "sidorovsidor@gmail.com", 89119229292L, 10500, 22);
        array[2] = new Employee("Annova Anna", "director", "annovaanna@gmail.com", 89111112233L, 100200500, 25);
        array[3] = new Employee("Kirkorov Filip", "chorist", "kirkorovfilip@gmail.com", 89998885273L, 8500, 75);
        array[4] = new Employee("Pomidor Ogurcov", "chorist", "pomidorogurcov@gmail.com", 89878653573L, 999500, 41);
        for (Employee x : array) {
            if (x.age > 40) x.print();
        }
    }
}
