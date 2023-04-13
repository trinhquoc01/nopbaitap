package CompanyManagement;

import java.util.Scanner;

public abstract class Person {

    private static int count = 0;
    private int id;
    protected String name;
    protected double bonus;
    protected double salary;

    public Person() {

        this.id = ++count;
    }
    public int getId() {

        return id;
    }
    public String getName() {

        return name;
    }
    public double getBonus() {

        return bonus;
    }
    public double getSalary() {

        return salary;
    }
    public double getTotal() {
        return bonus * salary + salary;
    }

    public abstract void input();
    public abstract void display();
    public abstract void updatePerson();

    public void updateSalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Salary update : ");
        salary = Integer.parseInt(scanner.nextLine());
        System.out.printf("new base salary : %0.1f %n ",salary);
    }
}

class Director extends Person {
    private String position;

    private Director() {
        super();
        bonus = 0.5;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        position = scanner.nextLine();
        System.out.print("Enter position : ");
        name = scanner.nextLine();
        System.out.print("Enter name : ");
        salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter salary : ");
        display();
    }

    @Override
    public void display() {
        System.out.printf("Director : id = %d ; position : %s ; salary = %.1f ; bonus = %.1f ; totalSalary = %.2f ", getId(), getName(), position, getSalary(), getBonus(), getTotal());
    }

    @Override
    public void updatePerson() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Update position : ");
        position = scanner.nextLine();

        System.out.print("Update name : ");
        name = scanner.nextLine();
        display();
    }
}

class Manager extends Person {

    private String department;

    public Manager() {
        super();
        bonus = 0.3;
    }

    public String getDepartment() {

        return department;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        department = scanner.nextLine();
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter salary : ");
        salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter department : ");
        display();
    }

    @Override
    public void display() {
        System.out.printf("Manager : id = %d, name = %s, department = %s, salary = %.1f, bonus = %.1f, totalSalary = %.1f",getId(), getName(), department, getSalary(), getBonus(), getTotal());
    }

    @Override
    public void updatePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Updete department : ");
        department = scanner.nextLine();
        System.out.print("Update name : ");
        name = scanner.nextLine();
        display();
    }
}
class Employee extends Person {

}