package task1;

import org.mariuszgromada.math.mxparser.Function;

public class SimpleIterationMethod implements SolvingMethod {
    @Override
    public Double solve(Function function, double a, double b, double epsilon) {
        double prevX = a;
        double nextX = function.calculate(prevX);
        while (Math.abs(nextX - prevX) >= epsilon){
            prevX = nextX;
            nextX = function.calculate(prevX);
        }
        return nextX;
    }
}
