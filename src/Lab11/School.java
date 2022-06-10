package Lab11;

import java.util.Arrays;

public class School implements ComputeAverage {
    @Override
    public double average(double[] x) {
        double sum = 0;
        for (double v : x) sum += v;
        return sum / x.length;
    }
}
