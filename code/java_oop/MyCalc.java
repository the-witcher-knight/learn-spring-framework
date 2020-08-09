import java.io.*;

class Calculator{
    int result;

    public void addition(int x, int y){
        result = x + y;
        System.out.println("The sum of the given numbers:"+ result);
    }

    public void subtraction(int x, int y){
        result = x - y;
        System.out.println("The difference between the given numbers:"+ result);
    }
}

public class MyCalc extends Calculator{
    public void multiplication(int a, int b){
        result = a * b;
        System.out.println("The product of the given numbers:"+ result);
    }
}