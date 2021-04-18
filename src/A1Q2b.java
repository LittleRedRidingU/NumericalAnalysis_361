import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Arrays;

public class A1Q2b {
    static double c = 0.95;
    //static double c = 1.55;
    //static double c = 2.0;
    //static double c = 3.6;
    //static double c = 3.98;
    static void result(double x,int n)
    {
        n=n+1;
        double fx = c*x*(1-x);
        display.AnswerSheet2[n] = fx;
        if(n < display.upBound-1){
            result(fx,n);
        }
    }
    public static void main(String[] args)
    {
        System.out.println("current c: "+c);
        display.upBound = 20;
        display.AnswerSheet2 = new double[display.upBound];
        display.AnswerSheet2[0]=0.1;
        result(display.AnswerSheet2[0],0);
        for(int i = 0; i < display.AnswerSheet2.length; i++) {
            System.out.println(display.AnswerSheet2[i]);
        }
        EventQueue.invokeLater(() -> {
            display.MyFrame frame = new display.MyFrame();
            frame.setVisible(true);
        });
    }

}
