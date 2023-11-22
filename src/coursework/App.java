package coursework;

import java.sql.Array;
import java.util.Locale;

public class App {
    //объявляем массив employees
    private static Employee[] employees = new Employee[10];

    //служебный метод, возврящает количество сотрудников" по заданному отделу, если dept=0, считается общее число
    private static int getEmployeeQty(int dept) {
        int employeesQty = 0;
        for (Employee employee: employees) {
            if (employee != null && (employee.getDepartment() == dept || dept == 0)) {
                employeesQty++;
            }
        }
        return employeesQty;
    }

    //метод "вывести в консоль список сотрудников"
    public static void printEmployeeList() {
        System.out.println("\nСписок данных всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    //метод "посчитать сумму затрат в месяц"
    public static double calculateSalarySum() {
        double sum = 0;
        for (Employee employee: employees) {
            if (employee != null) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }
    //метод "найти сотрудника с минимальной зарплатой"
    public static String getMinSalaryEmploee() {
        String nameOfMinSalaryEmployee = null;
        Double minSalary = Double.MAX_VALUE;
        for (Employee employee: employees) {
            if(employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                nameOfMinSalaryEmployee = employee.getName();
            }
        }
        return nameOfMinSalaryEmployee;
    }
    //метод "найти сотрудника с максимальной зарплатой"
    public static String getMaxSalaryEmploee() {
        String nameOfMaxSalaryEmployee = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee: employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                nameOfMaxSalaryEmployee = employee.getName();
            }
        }
        return nameOfMaxSalaryEmployee;
    }
    //метод "расчитать среднее значение зарплаты"
    public static double calculateAverageSalary() {
        int employeesQty = getEmployeeQty(0);
        if (employeesQty != 0) {
            return calculateSalarySum()/employeesQty;
        } else {
            return 0D;
        }
    }

    //метод "вывести в консоль ФИО всех сотрудников"
    public static void printNameList() {
       System.out.println("\nСписок имён всех сотрудников:");
        for (Employee employee: employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    //метод "индексация зарплат на заданный процент
    public static void makeSalaryIndexation (int indexationPercentage) {
        double increaseRate = 1 + indexationPercentage / 100D;
        for (Employee employee: employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * increaseRate );
            }
        }
    }
    //делаем служебный метод, собирающий массив сотрудников по заданному отделу
    private static Employee[] makeDepartmentArray(int department) {
        //собираем массив сотрудника отдела
        int deptEmploeeIndex = 0;
        Employee[] deptEmployees = new Employee[getEmployeeQty(department)];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                deptEmployees[deptEmploeeIndex] = employees[i];
                deptEmploeeIndex++;
            }
        }
        return deptEmployees;
    }
    //метод "вывести в консоль список сотрудников по заданному отделу"
    public static void printDepartmentEmployeeList(int department) {
        Employee[] deptEmploees = makeDepartmentArray(department);
        System.out.println("\nСписок сотрудников " + department + " отдела");
        for (Employee employee: deptEmploees) {
            if (employee != null) {
                System.out.printf(Locale.US, "Ф.И.О.: " + employee.getName() +
                        "; зарплата: %.2fр.; id: " + employee.getId() + "\n", employee.getSalary());
            }
        }
    }
    //метод "ищем сотрудника с минимальной зарплатой по отделу"
    public static String getMinSalaryEmploeeInDept(int department) {
        Employee[] deptEmploees = makeDepartmentArray(department);
        String nameOfMinSalaryEmployee = null;
        Double minSalary = Double.MAX_VALUE;
        for (Employee employee: deptEmploees) {
            if(employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                nameOfMinSalaryEmployee = employee.getName();
            }
        }
        return nameOfMinSalaryEmployee;
    }
    //метод "ищем сотрудника с максимальной зарплатой по отделу"
    public static String getMaxSalaryEmployeeInDept(int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        String nameOfMaxSalaryEmployee = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee: deptEmployees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                nameOfMaxSalaryEmployee = employee.getName();
            }
        }
        return nameOfMaxSalaryEmployee;
    }
    //метод "расчитать сумму затрат по отделу"
    public static double calculateDeptSalarySum(int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        double sum = 0;
        for (Employee employee : deptEmployees) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }
    //метод "расчтать среднюю зарплату по отделу"
    public static double calculateAverageDeptSalary(int department) {
        int employeeQty = getEmployeeQty(department);
        if (employeeQty != 0){
            return calculateDeptSalarySum(department) / getEmployeeQty(department);
        } else {
            return 0D;
        }
    }
    //метод "индексировать зарплаты по отделу на заданный процент
    public static void makeDeptSalaryIndexation (int indexationPercentage, int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        double increaseRate = 1 + indexationPercentage / 100D;
        for (Employee employee : deptEmployees) {
            employee.setSalary(employee.getSalary() * increaseRate );
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
        System.out.printf(Locale.US, "Среднее значение зарплат: %.2fр.\n", calculateAverageSalary());
        printNameList();
        makeSalaryIndexation(10);
        printEmployeeList();
        printDepartmentEmployeeList(1);
        System.out.println("\nСотрудник с минимальной зарплатой в отделе: " + getMinSalaryEmploeeInDept(1));
        System.out.println("Сотрудник с максимальной зарплатой в отделе: " + getMaxSalaryEmployeeInDept(1));
        System.out.println("Сумма затрат в месяц в отделе: " + calculateDeptSalarySum(1) + "p.");
        System.out.printf(Locale.US,"Средняя зарплата в отделе: %.2fр.\n", calculateAverageDeptSalary(1));
        //makeDeptSalaryIndexation(10, 1);
        //printDepartmentEmployeeList(1);
        //printEmployeesWithSalaryLessThan(40000);
        //printEmployeesWithSalaryMoreThan(40000);










    }

}
