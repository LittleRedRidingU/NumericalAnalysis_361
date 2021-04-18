public class NonLinearByNewTon {
    static int counterRecorder = 0;
    public static void newTonMethod(double x1, double x2, int counter){
        int xWhich = counterRecorder-counter;
        if (counter >= 0){
            System.out.println("x runtime ("+xWhich+") "+x1+" "+x2);
            double deltaX1 = getDeltaX1(x1,x2);
            double deltaX2 = getDeltaX2(x1,x2);
            double nextX1 = x1+deltaX1;
            double nextX2 = x2+deltaX2;
            newTonMethod(nextX1, nextX2, --counter);
        }
    }
    public static double getDeltaX1(double x1, double x2){
        return (-Math.pow(x1,6)+1)/((2*x1)*(x2+2*Math.pow(x1,4)));
    }
    public static double getDeltaX2(double x1, double x2){
        return (-Math.pow(x2,2)-x2*Math.pow(x1,4)+2*Math.pow(x1,2))/(2*Math.pow(x1,4)+x2);
    }
    public static void main(String[] args) {
        for(int x1=0; x1<4; x1++){
            for(int x2=0; x2<4; x2++){
                System.out.println("x1:"+x1+" "+"x2:"+x2);
                int counter = 10;
                counterRecorder = counter;
                //counter over here is for time of iterations
                newTonMethod(x1,x2, counter);
                System.out.println("////////////////////////////////////////");
            }
        }
    }
}
