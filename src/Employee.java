import org.w3c.dom.css.Counter;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private String name;
    private double salary;
    private int department;

    private final int id;
    private static int counter;

    public static int counterMaker () {
        counter ++;
        return counter;
    }

    public Employee (String name, int department, float salary) {

        this.id = counterMaker();
        this.name = name;
        this.department = department;
        this.salary = salary;

    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;

    }

    public String toString() {
        return
                "Имя: "+getName()+
                        " Отдел: "+this.getDepartment()+
                        " Зарплата: "+this.getSalary()+
                        " Табельный номер: "+this.getId();

    }
}

