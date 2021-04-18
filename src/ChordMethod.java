public class ChordMethod {
    static double initialXValue = 0.0;
    static int counterRecorder = 0;
    public static void Chord(double xValue, int counter){
        int xWhich = counterRecorder-counter;
        if (counter >= 0){
            System.out.println("x"+xWhich+" "+xValue);
            double nextX = xValue - (nextGx(xValue) / nextDeterminantGx(initialXValue));
            Chord(nextX, --counter);
    }
    }
    public static double nextGx(double xValue){
        return Math.pow(xValue,3)-5;
    }
    public static double nextDeterminantGx(double xValue){
        return 3*Math.pow(xValue,2);
    }
    public static void main(String[] args) {
        double xInitialize = 1;
        int counter = 10;
        counterRecorder = counter;
        initialXValue = xInitialize;
        Chord(xInitialize,counter);
    }
}
