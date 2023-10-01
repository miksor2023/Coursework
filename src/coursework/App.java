package coursework;

import java.sql.Array;

public class App {
    //объявляем массив employees
    static Employee[] employees = new Employee[10];
    //метод "добавить сотрудника"
    public static void addEmployee(String name, int department, int salary) {
        if (Employee.getEmploeeQty() == employees.length) {
            System.out.println("Запись добавить невозможно, хранилище заполнено");
        } else {
            Employee newEmloyee = new Employee(name, department, salary);
            employees[newEmloyee.getId()] = newEmloyee;
        }
    }
    //метод "вывести в консоль список сотрудников"
    public static void printEmployeeList() {
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            System.out.println(employees[i]);
        }
    }
    //метод "посчитать сумму затрат в месяц"
    public static int calculateSalarySum() {
        int sum = 0;
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            sum = sum + employees[i].getSalary();
        }
        return sum;
    }
    //метод "найти сотрудника с минимальной зарплатой"
    public static



    public static void main(String[] args) {

        addEmployee("Иванов Иван Иванович", 3, 35000);
        addEmployee("Сидоров Пётр Петрович", 2, 36000);
        addEmployee("Петров Дмитрий Сергеевич", 2, 40500);
        addEmployee("Сергеев Олег Дмитриевич", 1, 28700);
        addEmployee("Лидов Марат Исакович", 1, 34900);
        addEmployee("Розин Андрей Гаврилович", 3, 36000);
        addEmployee("Жорин Евгений Михайлович", 3, 78050);
        addEmployee("Кабанов Абрам Романович", 1, 33300);
        printEmployeeList();
        System.out.println("Сумма затрат на зарплату за месяц: " + calculateSalarySum());







    }

}
