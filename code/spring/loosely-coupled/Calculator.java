import java.io.*;

interface CalcAlgorithm{
    public void calc();
}

class Addition implements CalcAlgorithm {

    @Override
    public void calc(){
        System.out.println("tong");
    }

}

class Substraction implements CalcAlgorithm {

    @Override
    public void calc(){
        System.out.println("hieu");
    }
}

class HandleCalc {
    private CalcAlgorithm calcAlgorithm;

    public HandleCalc(CalcAlgorithm calAlgorithm){
        this.calcAlgorithm = calcAlgorithm;
    }

    public void returnResult(){
        calcAlgorithm.calc();
    }
}

public class Calculator{
    public static void main(String[] args){
        CalcAlgorithm add = new Addition();
        HandleCalc calculator = new HandleCalc(add);
    }
}