package coursework;

public class App {
    //объявляем массив
    static Employee[] employees = new Employee[10];
    public static void addEmployee(String name, int department, int salary) {
        Employee newEmloyee = new Employee(name, department, salary);
        employees[newEmloyee.getId()] = newEmloyee;
    }
    public static void printEmployeeList() {
        for (int i = 0; i <= Employee.counter - 1; i++) {
            System.out.println(employees[i]);
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
        addEmployee("Панов Абрам Романович", 1, 33300);
        printEmployeeList();







    }

}
