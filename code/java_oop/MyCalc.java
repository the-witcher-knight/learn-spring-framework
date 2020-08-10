import java.io.*;

class Calculator{
    int result;
    int x;
    int y;

    public Calculator(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void addition(int x, int y){
        result = x + y;
        System.out.println("The sum of the given numbers:"+ result);
    }

    public void subtraction(int x, int y){
        result = x - y;
        System.out.println("The difference between the given numbers:"+ result);
    }

    public void getResult(){
        result = x + y;
        System.out.println("Ket qua la:"+ result);
    }
}

public class MyCalc extends Calculator{

    public MyCalc(int x, int y){
        super(x, y);
    }

    public void multiplication(int a, int b){
        result = a * b;
        System.out.println("The product of the given numbers:"+ result);
    }
}