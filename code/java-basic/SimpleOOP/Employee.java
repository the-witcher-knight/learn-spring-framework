import java.io.*;

public class Employee{
    String name;
    int age;
    double salary;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public void printEmployee(){
        System.out.println("Name:"+ name );
        System.out.println("Age:" + age );
        System.out.println("Salary:" + salary);
    }
}