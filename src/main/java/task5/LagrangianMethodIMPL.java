package task5;

import org.mariuszgromada.math.mxparser.Function;

public class LagrangianMethodIMPL {

    private static final double[][] input = {
            {-1, 3},
            {0, -1},
            {1, 2}
    };

    public static void main(String[] args) {
        String functionStr = getFunctionStr();
        Function functionL = new Function("f(x) = " + functionStr);

        for (int i = 0; i < input.length; i++) {
            System.out.println(functionL.calculate(input[i][0]));
        }
    }

    private static String getFunctionStr() {
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
