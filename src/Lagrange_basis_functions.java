public class Lagrange_basis_functions {
    static int setM = 500;
    static int setN = 2;
    //static int setN = 4;
    //static int setN = 8;
    //static int setN = 16;
    public static double LBF(int whichPoint_i, int howManyN, double inputX){
        int[] pointsOtherThan_i = pointArray(whichPoint_i, howManyN);
        return coefficients_li_element(pointsOtherThan_i, whichPoint_i, inputX);
    }
    public static int[] pointArray(int whichPoint_i, int howManyN){
        int[] pointsOtherThan_i = new int[howManyN];
        int points = 0;
        for(int j = 0; j<howManyN; j++){
            if(j==whichPoint_i){
                pointsOtherThan_i[j] = ++points;
            }else {
                pointsOtherThan_i[j] = points;
            }
            points++;
        }
        return pointsOtherThan_i;
    }
    public static double coefficients_li_element(int[] pointsOtherThan_i, int whichPoint_i, double inputX){
        double li_element = 1;
        for(int element: pointsOtherThan_i){
            li_element = li_element * ((inputX-element)/(whichPoint_i-element));
         }
         return li_element;
    }

    public static double Polynomial_interpolation(int howManyN, double inputX) {
        double Polynomial_P = 0;
        for(int j = 0; j<howManyN+1; j++) {
            Polynomial_P = Polynomial_P + fx_formula_using(inputX)*LBF(j, howManyN, inputX);
        }
        return Polynomial_P;
    }
    public static double fx_formula_using(double x){
        //requirement 1
            // return Math.sin(Math.PI*x);
        //requirement 2 & 3
             return 1/(1+Math.pow(x,2));
    }

    public static double maximumInterpolationError(int howManyN){
        double Temp, maxErrorRecorder = -1;
        double[] EquallySpacedArray = intervalEquallySpacedByM();
       for(int j = 0; j<setM+1; j++){
            Temp=Math.abs(fx_formula_using(EquallySpacedArray[j])-Polynomial_interpolation(howManyN, EquallySpacedArray[j]));
            if (Temp>maxErrorRecorder){
                maxErrorRecorder = Temp;
            }
        }
        return maxErrorRecorder;
    }

    public static double[] intervalEquallySpacedByM(){
        double[] EquallySpacedArray = new double[setM+1];
        double intervalDistance, lowestPoint;

        //requirement 1
              //  lowestPoint = -1;
              //  intervalDistance = 2.0/(setM+1); //note: The distance between -1 and 1 is 2
        //requirement 2
              lowestPoint = -2;
              intervalDistance = 4.0/(setM+1); //note: The distance between -2 and 2 is 4
        //requirement 3
            // lowestPoint = -5;
             //intervalDistance = 10.0/(setM+1);  //note: The distance between -5 and 5 is 10

        for(int j = 0; j<EquallySpacedArray.length; j++){
            if(j==0){
                EquallySpacedArray[j] = lowestPoint;
                continue;
            }
            lowestPoint = lowestPoint+intervalDistance;
            EquallySpacedArray[j] = lowestPoint;
        }
        return EquallySpacedArray;
    }

    public static void main(String[] args) {
        int howManyN = setN;
        System.out.println("For case n = " + setN +", the approximate maximum interpolation error is: "+maximumInterpolationError(howManyN));
    }
}
