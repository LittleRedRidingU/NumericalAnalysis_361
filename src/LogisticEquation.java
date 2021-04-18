public class LogisticEquation {
    static int counterRecorder = 0;
    static double c = 0;

    public static void Logistic(double xValue, int counter){
        int xWhich = counterRecorder-counter;
        if (counter >= 0){
            System.out.println("x"+xWhich+" "+xValue);
            double nextX = c*xValue*(1-xValue);
            Logistic(nextX, --counter);
        }
    }
    public static void main(String[] args) {
        c = 1;
        double xInitialize = 0.7;
        int counter = 3000;
        counterRecorder = counter;
        Logistic(xInitialize,counter);
    }
}
