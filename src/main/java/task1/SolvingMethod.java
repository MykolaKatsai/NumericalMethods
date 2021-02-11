package task1;

import org.mariuszgromada.math.mxparser.Function;

public interface SolvingMethod {
    Double solve(Function function, double a, double b, double epsilon);

}
