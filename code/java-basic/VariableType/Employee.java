import java.io.*;

public class Employee{
    private static double salary;

    public static final String DEPARTMENT = "Development";

    public static void setSalary(){
        salary = 10000;
    }

    public static void printEmployee(){
        System.out.println(DEPARTMENT + " average salary " + salary);
    }
}