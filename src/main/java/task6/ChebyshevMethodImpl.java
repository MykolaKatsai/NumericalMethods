package task6;

public class ChebyshevMethodImpl {

    //values for function f=arctan(2x)
    private static final double[] input = {
            1.1009971305064690925,
            1.0471975511965977461,
            0.90970073709819939446,
            0.59993424850586212036,
            0d,
            -0.59993424850586212036,
            -0.90970073709819939446,
            -1.0471975511965977461,
            -1.1009971305064690925
    };

    private static String[] tPolynomials;
    private static double[] x;
    private static double[] aCoefficients;

    public static void main(String[] args) {
        tPolynomials = getTPolynomials(input.length);
        x = getX(input.length);
        aCoefficients = getACoefficients(input.length);

        System.out.println("Check x_k points:");
        for (double d : x) {
            System.out.println(countCFunction(d));
        }

        System.out.println();
        System.out.println("Check control points:");
        System.out.println(countCFunction(-0.9));
        System.out.println(countCFunction(-0.3));
        System.out.println(countCFunction(0.3));
        System.out.println(countCFunction(0.9));
    }

    private static String[] getTPolynomials(int i) {
        String[] tPolynomials = new String[i];
        tPolynomials[0] = "1";
        tPolynomials[1] = "x";

        for (int j = 2; j < i; j++) {
            StringBuilder str = new StringBuilder();
            str.append("2*(x*(");
            str.append(tPolynomials[j - 1]);
            str.append(")) - (");
            str.append(tPolynomials[j - 2]);
            str.append(")");
            tPolynomials[j] = str.toString();
        }
        return tPolynomials;
    }

    private static double getTPolynomialVal(int i, double val) {
        if (i == 0)
            return 1d;
        if (i == 1)
            return val;

        double[] values = new double[i + 1];
        values[0] = 1d;
        values[1] = val;
        for (int j = 2; j <= i; j++) {
            values[j] = 2 * val * values[j - 1] - values[j - 2];
        }
        return values[values.length - 1];
    }

    private static double countCFunction(double x) {
        double res = 0;
        for (int i = 0; i < input.length; i++) {
            res += aCoefficients[i] * getTPolynomialVal(i, x);
        }

        return res;
    }

    private static double[] getACoefficients(int n) {
        double[] coefficients = new double[n];

        double eps0 = 0;
        for (int i = 0; i < n; i++) {
            eps0 += input[i];
        }
        coefficients[0] = (1d / n) * eps0;

        for (int k = 1; k < n; k++) {
            double eps = 0;

            for (int i = 0; i < n; i++) {
                eps += input[i] * getTPolynomialVal(k, x[i]);//(new Function("f(x) = " + tPolynomials[k])).calculate(x[i]);
            }

            coefficients[k] = (2d / n) * eps;
        }
        return coefficients;
    }

    private static double[] getX(int n) {
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = Math.cos((Math.PI * (2 * i + 1)) / (2 * n));
        }
        return x;
    }
}
