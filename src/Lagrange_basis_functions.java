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
            Polynomial_P = Polynomial_P + fx_formula_using(j)*LBF(j, howManyN, inputX);
        }
        return Polynomial_P;
    }
    public static double fx_formula_using(int x){
        //test_requirement
        return Math.exp(x);
        //requirement 1
        //return Math.sin(x);
        //requirement 2
        // return 1/(1+Math.pow(x,2));
        //requirement 3
        // return 1/(1+Math.pow(x,2));
    }
    public static void main(String[] args) {
        double desiredApproximationValue_X = 1.5;
        int polynomial_interpolation_number_n = setN;
        System.out.println(Polynomial_interpolation(polynomial_interpolation_number_n, desiredApproximationValue_X));
    }
}
