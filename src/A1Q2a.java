import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Arrays;

public class A1Q2a {
    static void result(double x,int n)
    {
        n=n+1;
        double fx = (2.0*Math.pow(x,3)+5.0)/(3.0*Math.pow(x,2));
        display.AnswerSheet2[n] = fx;
        if(n < display.upBound-1){
            result(fx,n);
        }
    }
    public static void main(String[] args)
    {
        display.upBound = 20;
        display.AnswerSheet2 = new double[display.upBound];
        display.AnswerSheet2[0]=1.0;
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
