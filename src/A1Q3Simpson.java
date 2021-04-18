import java.awt.*;
import java.util.Arrays;

public class A1Q3Simpson {
    public static double simpRule(int M){
        double h = (double) 1 / M;
        double P = 0.0;
        double[] fx = new double[M+1];
        for(int k = 0; k <= M; k++) {
            double xi = k * h;
            fx[k] = Math.sin((xi)*Math.PI);
        }
        P = P+fx[0]+fx[M];
        for(int k = 1; k < M; k++) {
            if(k%2 != 0) {
                P = P + 4 * fx[k];
            }else{
                P = P + 2 * fx[k];
            }
        }
        return P*h/3;
    }
    public static void main(String[] args){
        int k = 0;
        double exact1 = A1Q3exactvalue.exact;
        System.out.println("The exact value is "+exact1);
        for(int i = 2; i <= Math.pow(2,display.upBound); i=i*2){
            display.AnswerSheet2[k] = simpRule(i);
            System.out.println("Turn "+(k+1)+" where i equals "+i+". The approximation is " +display.AnswerSheet2[k]);
            if((int)(exact1*Math.pow(10,6)) == (int)(display.AnswerSheet2[k]*Math.pow(10,6))){
                System.out.println("The error is less than 10^-7, therefore, program terminated at 2^" + (display.upBound)+". That is M equals "+Math.pow(2,display.upBound));
                break;
            }else if(i >= Math.pow(2,display.upBound)){
                display.upBound++;
                display.AnswerSheet2 = Arrays.copyOf(display.AnswerSheet2,display.upBound);
            }
            k++;
        }
        System.out.println("test M = 48 " +simpRule(48));
        EventQueue.invokeLater(() -> {
            display.MyFrame frame = new display.MyFrame();
            frame.setVisible(true);
        });
    }

}
