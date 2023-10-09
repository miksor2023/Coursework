package coursework;

import java.sql.Array;
import java.util.Locale;

public class App {
    //объявляем массив employees
    private static Employee[] employees = new Employee[10];

    //метод "вывести в консоль список сотрудников"
    public static void printEmployeeList() {
        System.out.println("\nСписок данных всех сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }
    //метод "посчитать сумму затрат в месяц"
    public static double calculateSalarySum() {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum = sum + employees[i].getSalary();
            }
        }
        return sum;
    }
    //метод "найти сотрудника с минимальной зарплатой"
    public static String getMinSalaryEmploee() {
        //перебираем массив до первой непустой ячейки и инициализируем переменную minSalary
        Double minSalary = 0D;
        for (int i = 0; i <= employees.length; i++) {
            if (employees[i] != null) {
                minSalary = employees[i].getSalary();
                break;
            }
        }
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        if
        return employees[index].getName();
    }
    //метод "найти сотрудника с максимальной зарплатой"
    public static String getMaxSalaryEmploee() {
        double maxSalary = 0;
        int index = 0;
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index].getName();
    }
    //метод "расчитать среднее значение зарплаты"
    public static double calculateAverageSalary() {
        int employeesQty = 0;
        for (int i = 0; int <= employees.length; i++) {
            if (employees[i] != null) {
                employeesQty++
            }
        }
        return calculateSalarySum()/Employee.getEmploeeQty();
    }

    //метод "вывести в консоль ФИО всех сотрудников"
    //public static void printNameList() {
    //   System.out.println("\nСписок имён всех сотрудников:");
    //    for (int i = 0; i < Employee.getEmploeeQty(); i++) {
    //        System.out.println(employees[i].getName());
    //    }
    //}
    //метод "индексация зарплат на заданный процент
    public static void makeSalaryIndexation (int indexationPercentage) {
        double increaseRate = 1 + indexationPercentage / 100D;
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() * increaseRate );
        }
    }
    //делаем служебный метод, собирающий массив сотрудников по заданному отделу
    public static Employee[] makeDepartmentArray(int department) {
        //собираем массив сотрудника отдела
        int deptEmploeeQty = 0;
        Employee[] deptEmployees = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                deptEmployees[deptEmploeeQty] = employees[i];
                deptEmploeeQty++;
            }
        }
        if (deptEmploeeQty == 0) {
            System.out.println("В базе нет сотрудников из отдела " + department);
        }
        //создаём массив без пустых полей и возвращаем его
        Employee[] deptEmployeesModified = new Employee[deptEmploeeQty];
        for (int i = 0; i < deptEmploeeQty; i++) {
            deptEmployeesModified[i] = deptEmployees[i];
        }
        return deptEmployeesModified;
    }
    //метод "вывести в консоль список сотрудников по заданному отделу"
    public static void printDepartmentEmployeeList(int department) {
        Employee[] deptEmploees = makeDepartmentArray(department);
        System.out.println("\nСписок сотрудников " + department + " отдела");
        for (int i = 0; i < deptEmploees.length; i++) {
            System.out.printf (Locale.US,"Ф.И.О.: " + deptEmploees[i].getName() +
                    "; зарплата: %.2fр.; id: " + deptEmploees[i].getId() + "\n", deptEmploees[i].getSalary());
        }
    }
    //метод "ищем сотрудника с минимальной зарплатой по отделу"
    public static String getMinSalaryEmploeeInDept(int department) {
        Employee[] deptEmploees = makeDepartmentArray(department);
        double minSalary = deptEmploees[0].getSalary();
        int index = 0;
        for (int i = 1; i < deptEmploees.length; i++) {
            if (deptEmploees[i].getSalary() < minSalary) {
                minSalary = deptEmploees[i].getSalary();
                index = i;
            }
        }
        return deptEmploees[index].getName();
    }
    public static String getMaxSalaryEmployeeInDept(int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        double maxSalary = deptEmployees[0].getSalary();
        int index = 0;
        for (int i = 1; i < deptEmployees.length; i++) {
            if (deptEmployees[i].getSalary() > maxSalary) {
                maxSalary = deptEmployees[i].getSalary();
                index = i;
            }
        }
        return deptEmployees[index].getName();
    }
    //метод "расчитать сумму затрат по отделу"
    public static double calculateDeptSalarySum(int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        double sum = 0;
        for (int i = 0; i < deptEmployees.length; i++) {
            sum = sum + deptEmployees[i].getSalary();
        }
        return sum;
    }
    //метод "расчтать среднюю зарплату по отделу"
    public static double calculateAverageDeptSalary(int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        //условие - если количество людей в отделе совпадает с общим числом сотрудников
        if (deptEmployees.length == employees.length) {
            throw new IllegalArgumentException("количество людей в отделе совпадает с общим числом сотрудников");
        } else {
            return calculateDeptSalarySum(department) / deptEmployees.length;
        }
    }
    //метод "индексировать зарплаты по отделу на заданный процент
    public static void makeDeptSalaryIndexation (int indexationPercentage, int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        double increaseRate = 1 + indexationPercentage / 100D;
        for (int i = 0; i < deptEmployees.length; i++) {
            deptEmployees[i].setSalary(deptEmployees[i].getSalary() * increaseRate );
        }

    }
    //метод для вывода списка сотрудников с ЗП меньше заданного значения
    public static void printEmployeesWithSalaryLessThan (double edgeSalary) {
        System.out.println("\nСписок сотрудников с зарплатой меньше " + edgeSalary + "р.");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < edgeSalary) {
                System.out.printf(Locale.US, "id: " + employees[i].getId() + "; Ф.И.О.: " +
                        employees[i].getName() + "; зарплата: %.2fр.\n", employees[i].getSalary());
            }
        }
    }
    //метод для вывода списка сотрудников с ЗП больше заданного значения
    public static void printEmployeesWithSalaryMoreThan (double edgeSalary) {
        System.out.println("\nСписок сотрудников с зарплатой больше или равно " + edgeSalary + "р.");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= edgeSalary) {
                System.out.printf(Locale.US, "id: " + employees[i].getId() + "; Ф.И.О.: " +
                        employees[i].getName() + "; зарплата: %.2fр.\n", employees[i].getSalary());
            }
        }
    }
    //метод main - тесты
    public static void main(String[] args) {

        employees[0] = new Employee("Иванов Иван Иванович", 2, 35000);
        employees[1] = new Employee("Сидоров Пётр Петрович", 1, 36000);
        employees[2] = new Employee("Петров Дмитрий Сергеевич", 2, 40500);
        employees[3] = new Employee("Сергеев Олег Дмитриевич", 2, 28700);
        employees[4] = new Employee("Лидов Марат Исакович", 1, 34900);
        employees[5] = new Employee("Розин Андрей Гаврилович", 3, 36000);
        employees[6] = new Employee("Жорин Евгений Михайлович", 1, 78050);
        employees[7] = new Employee("Кабанов Абрам Романович", 3, 33300);
        printEmployeeList();
        System.out.println("\nСумма затрат на зарплату за месяц: " + calculateSalarySum() + "p.");
        System.out.println("Сотрудник с минимальной зарплатой: " + getMinSalaryEmploee());
        System.out.println("Сотрудник с максимальной зарплатой: " + getMaxSalaryEmploee());
        //System.out.printf(Locale.US, "Среднее значение зарплат: %.2fр.\n", calculateAverageSalary());
        //printNameList();
        //makeSalaryIndexation(10);
        //printEmployeeList();
        //printDepartmentEmployeeList(1);
        //System.out.println("\nСотрудник с минимальной зарплатой в отделе: " + getMinSalaryEmploeeInDept(1));
        //System.out.println("Сотрудник с максимальной зарплатой в отделе: " + getMaxSalaryEmployeeInDept(1));
        //System.out.println("Сумма затрат в месяц в отделе: " + calculateDeptSalarySum(1) + "p.");
        //System.out.printf(Locale.US,"Средняя зарплата в отделе: %.2fр.\n", calculateAverageDeptSalary(1));
        //makeDeptSalaryIndexation(10, 1);
        //printDepartmentEmployeeList(1);
        //printEmployeesWithSalaryLessThan(40000);
        //printEmployeesWithSalaryMoreThan(40000);










    }

}
