public class NewtonMethodForR {
    static int counterRecorder = 0;
    static int R= 0;
    public static void newTonMethod(double xValue, int counter){
        int xWhich = counterRecorder-counter;
        if (counter >= 0){
            System.out.println("x runtime ("+xWhich+") "+xValue);
            double nextX = (xValue+R/xValue)/2;
            newTonMethod(nextX, --counter);
        }
    }
    public static void main(String[] args) {
                int counter = 25;
                R = 2;
                double initialXValue = 1;
                counterRecorder = counter;
                //counter over here is for time of iterations
                newTonMethod(initialXValue, counter);
    }
}
