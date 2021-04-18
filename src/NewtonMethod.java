import java.awt.*;
import java.util.Arrays;

public class NewtonMethod {
    static int counterRecorder = 0;
    public static void newTonMethod(double xValue, int counter){
        int xWhich = counterRecorder-counter;
        if (counter >= 0){
            System.out.println("x"+xWhich+" "+xValue);
            double nextX = xValue - (nextGx(xValue) / nextDeterminantGx(xValue));
            newTonMethod(nextX, --counter);
        }
    }
    public static double nextGx(double xValue){
        return Math.pow(xValue,3)-5;
    }
    public static double nextDeterminantGx(double xValue){
        return 3*Math.pow(xValue,2);
    }
    public static void main(String[] args) {
        double xInitialize = 20;
        int counter = 20;
        counterRecorder = counter;
        //counter over here is for time of iterations
        newTonMethod(xInitialize,counter);
    }
}
