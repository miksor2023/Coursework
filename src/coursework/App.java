package coursework;

import java.sql.Array;
import java.util.Locale;

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
        System.out.println("\nСписок данных всех сотрудников:");
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
    public static String getLowestSalaryEmploee() {
        int minSalary = employees[0].getSalary();
        int index = 0;
        for (int i = 1; i < Employee.getEmploeeQty(); i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index].getName();
    }
    //метод "найти сотрудника с максимальной зарплатой"
    public static String getHighestSalaryEmploee() {
        int maxSalary = employees[0].getSalary();
        int index = 0;
        for (int i = 1; i < Employee.getEmploeeQty(); i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index].getName();
    }
    //метод "расчитать среднее значение зарплаты"
    public static double calculateAverageSalary() {
        return calculateSalarySum()/Employee.getEmploeeQty();
    }

    //метод "вывести в консоль ФИО всех сотрудников"
    public static void printNameList() {
        System.out.println("\nСписок имён всех сотрудников:");
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            System.out.println(employees[i].getName());
        }
    }



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
        System.out.println("\nСумма затрат на зарплату за месяц: " + calculateSalarySum() + " p.");
        System.out.println("Сотрудник с минимальной зарплатой: " + getLowestSalaryEmploee());
        System.out.println("Сотрудник с максимальной зарплатой: " + getHighestSalaryEmploee());
        System.out.printf(Locale.US, "Среднее значение зарплат: %.2f р.\n", calculateAverageSalary());
        printNameList();







    }

}
