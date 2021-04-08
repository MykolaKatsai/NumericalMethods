package task1;

import org.mariuszgromada.math.mxparser.Function;

public class EquationsSolver {
    private static final String FUNCTION = "-x^2 + 0.1";
    private static final String X_FUNCTION = "-x^2 + 0.1 + x";
    private static final double A = 0d;
    public static final double B = 1d;
    public static final double EPSILON = 0.00000001d;

    private static SolvingMethod method1 = new DivisionInHalfMethod();
    private static SolvingMethod method2 = new SimpleIterationMethod();
    public static void main(String[] args) {
        Function function = new Function("f", FUNCTION, "x");

        Double solution1 = method1.solve(function, A, B, EPSILON);

        System.out.printf("f(x) = %s = 0, (%s <= x <= %s) \nWhen x = %s", FUNCTION, A, B, solution1);


        System.out.println("\n\n");
        Function xFunction = new Function("g", X_FUNCTION, "x");

        Double solution2 = method2.solve(xFunction, A, B, EPSILON);

        System.out.printf("f(x) = %s = 0, (%s <= x <= %s) \nWhen x = %s\n", FUNCTION, A, B, solution2);
    }
}
