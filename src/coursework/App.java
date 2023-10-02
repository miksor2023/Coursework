package coursework;

import java.sql.Array;
import java.util.Locale;

public class App {
    //объявляем массив employees
    static Employee[] employees = new Employee[10];
    //метод "добавить сотрудника"
    public static void addEmployee(String name, int department, double salary) {
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
    public static double calculateSalarySum() {
        double sum = 0;
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            sum = sum + employees[i].getSalary();
        }
        return sum;
    }
    //метод "найти сотрудника с минимальной зарплатой"
    public static String getMinSalaryEmploee() {
        double minSalary = employees[0].getSalary();
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
    public static String getMaxSalaryEmploee() {
        double maxSalary = employees[0].getSalary();
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
    //метод "индексация зарплат на заданный процент
    public static void makeSalaryIndexation (int indexationPercentage) {
        double increaseRate = 1 + indexationPercentage / 100D;
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            employees[i].setSalary(employees[i].getSalary() * increaseRate );
        }
    }
    //метод "найти сотрудника с минимальной зарплатой по заданному отделу"
    public static String getLowestSalaryEmploeeInDepartment(int department) {
        //собираем массив сотрудника отдела
        int deptEmploeeQty = 0;
        static Employee[] deptEmployees = new Employee[Employee.getEmploeeQty()];
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            if (employees[i].getDepartment() == department) {
                    deptEmployees[deptEmploeeQty] = employees[i];
                    deptEmploeeQty++;
            }
        }
        if (deptEmploeeQty == 0) {
            System.out.println("В базе нет сотрудников из отдела " + department);
            return;
        }
        //ищем сотрудника
        double minSalary = deptEmployees[0].getSalary();
        int index = 0;
        for (int i = 1; i < Employee.getEmploeeQty(); i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index].getName();
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
        System.out.println("\nСумма затрат на зарплату за месяц: " + calculateSalarySum() + "p.");
        System.out.println("Сотрудник с минимальной зарплатой: " + getMinSalaryEmploee());
        System.out.println("Сотрудник с максимальной зарплатой: " + getMaxSalaryEmploee());
        System.out.printf(Locale.US, "Среднее значение зарплат: %.2fр.\n", calculateAverageSalary());
        printNameList();
        makeSalaryIndexation(10);
        printEmployeeList();







    }

}
