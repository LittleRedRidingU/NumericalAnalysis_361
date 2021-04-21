public class Lagrange_Interpolation {
    static int setM = 500;
    static int setRequirement = 0;

    public static double[] linearlySpacedVectors(double start, double end, int length){
        double[] arr = new double[length];
        double step = (end - start) / (length - 1);
        for(int j = 0; j < length; ++j){
            arr[j] = arr[j] + step * j;
        }
        return arr;
    }

    public static double lagrangeInterP(double[] n_Spaced, double[] fx, double x_m){
        double Polynomial_P = 0;
        for (int j = 0; j < n_Spaced.length; j++){
            double li_element = 1;
            for(int k = 0; k < n_Spaced.length; k++) {
                if (k != j) {
                    li_element *= ((x_m - n_Spaced[k]) / (n_Spaced[j] - n_Spaced[k]));
                }
            }
            Polynomial_P += li_element * fx[j];
        }
        return Polynomial_P;
    }

    public static double[] mapArray(double[] arr) {
        double[] fx = new double[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            fx[i] = function_using(arr[i]);
        }
        return fx;
    }

    public static double function_using(double x){
        switch (setRequirement) {
            case 1:
                return Math.sin(Math.PI * x);
            default:
                return 1 / (1 + Math.pow(x, 2));
        }
    }

    public static int[] getInterval(){
        switch (setRequirement){
            //requirement 1
            case 1: return new int[]{-1, 1};
            //requirement 2
            case 2: return new int[]{-2, 2};
            //requirement 3
            case 3: return new int[]{-5, 5};
            default: return new int[2];
        }
    }

    public static void main(String[] args) {
        setRequirement = 2;
        int[] f_interval = getInterval();
        double[] M_EquallySpacedArray = linearlySpacedVectors(f_interval[0],f_interval[1],setM+1);
        for (int n = 2; n <= 16; n *= 2) {
            double[] n_EquallySpacedArray = linearlySpacedVectors(f_interval[0],f_interval[1],n+1);
            double[] fx = mapArray(n_EquallySpacedArray);
            double[] InterpolationErrors = new double[setM+1];
            double max_InterP_Err = 0.0;
            for (double x_m : M_EquallySpacedArray) {
                double Polynomial_P = lagrangeInterP(n_EquallySpacedArray, fx, x_m);
                double err = Math.abs(function_using(x_m) - Polynomial_P);
                if (err > max_InterP_Err) max_InterP_Err = err;
            }
            System.out.println("For case n = " + n+" , the approximate maximum interpolation error is: " + max_InterP_Err);
         }
    }
}
