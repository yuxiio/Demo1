package Lab11;

import java.util.Arrays;

public class SongGame implements ComputeAverage {
    @Override
    public double average(double[] x) {
        Arrays.sort(x);
        double sum = 0;
        for(int i=1;i<x.length-1;i++)
            sum += x[i];
        return sum/(x.length-2);
    }
}
