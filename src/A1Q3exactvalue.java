import java.util.*;

public class A1Q3exactvalue {
    static double exact = integral(0,1);
    public static double integral(double a, double b) {

        double sum = 0;
        double e = cha(a, b, 20000.0);

        for (int j = 1; j <= 20000; j++) {
            double x = mid(a, b, 20000.0, j);
            sum = sum + f(x);
        }
        return Math.abs(sum * e);
    }

    public static double f(double x) {
        return Math.sin(x*Math.PI);
    }

    public static double mid(double a, double b, double n, int i) {
        return a + i * (b - a) / n;
    }

    public static double cha(double a, double b, double n) {
        return (b - a) / n;
    }
}