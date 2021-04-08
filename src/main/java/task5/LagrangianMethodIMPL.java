package task5;

import org.mariuszgromada.math.mxparser.Function;

public class LagrangianMethodIMPL {

    private static final double[][] input = {
            {-1, 3},
            {0, -1},
            {1, 2}
    };

    private static final double[][] input1 = {
            {-1, -1.1071487177940905030},
            {-0.75, -0.98279372324732906799},
            {-0.5, -0.78539816339744830962},
            {-0.25, -0.46364760900080611621},
            {0, 0},
            {0.25, 0.46364760900080611621},
            {0.5, 0.78539816339744830962},
            {0.75, 0.98279372324732906799},
            {1, 1.1071487177940905030}
    };

    public static void main(String[] args) {
        String functionStr = getFunctionStr(input1);
        Function functionL = new Function("f(x) = " + functionStr);

        for (int i = 0; i < input1.length; i++) {
            System.out.println(functionL.calculate(input1[i][0]));
        }

        System.out.println();
        System.out.println("Check control values:");
        System.out.println(functionL.calculate(-0.9d));
        System.out.println(functionL.calculate(-0.3d));
        System.out.println(functionL.calculate(0.3d));
        System.out.println(functionL.calculate(0.9d));
    }

    private static String getFunctionStr(double[][] input) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            str.append("(");
            str.append(input[i][1]);
            str.append(")*");
            double d = 1; //denominator

            for (int j = 0; j < input.length; j++) {
                if (j != i) {
                    str.append("(x - (");
                    str.append(input[j][0]);
                    str.append("))*");
                    d *= (input[i][0] - input[j][0]);
                }
            }
            str.deleteCharAt(str.length() - 1);
            str.append("/(");
            str.append(d);
            str.append(") + ");
        }

        str.deleteCharAt(str.length() - 1);
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
}
