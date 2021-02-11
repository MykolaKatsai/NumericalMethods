package task1;

import org.mariuszgromada.math.mxparser.*;

public class DivisionInHalfMethod implements SolvingMethod {


    @Override
    public Double solve(Function function, double a, double b, double epsilon) {
        boolean isAsc = function.calculate(a) < 0;// is f(a) < 0
        double mid = (a + b) / 2;

        while (b - a >= epsilon) {
            double midF = function.calculate(mid);

            if (midF < 0) {
                if (isAsc) {
                    a = mid;
                } else {
                    b = mid;
                }
            } else if (midF > 0) {
                if (isAsc) {
                    b = mid;
                } else {
                    a = mid;
                }
            } else {
                return mid;
            }

            mid = (a + b) / 2;
        }
        return Math.floor(mid / epsilon) * epsilon;
    }
}
