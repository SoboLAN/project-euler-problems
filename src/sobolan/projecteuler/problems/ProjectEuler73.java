package sobolan.projecteuler.problems;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 */
public class ProjectEuler73 extends AbstractExecutableProblem
{
    private final int D = 12000;
    private final double START = (double) 1/3;
    private final double END = (double) 1/2;

    @Override
    public String getResult()
    {
        HashSet<Double> values = new HashSet<>();

        for (int d = this.D; d >= 2; d--) {
            //System.out.println(d);
            for (int n = (int) Math.floor(d * this.START) + 1; n <= (int) Math.floor(d * this.END); n++) {
                Double value = 1.0 * n / d;
                //System.out.println(value.toString());
                if (! values.contains(value)) {
                    values.add(value);
                }
            }
        }


//for (int d = this.D; d >= 2; d--) {
//            for (int n = (int) Math.ceil(d * this.START); n <= (int)Math.floor(d * this.END) && n < d; n++) {
//                System.out.printf("%d/%d ", n, d);
//                System.out.println();
//                //count++;
//            }
//        }
//double value = (double) n / d;
                //if (Double.compare(value, this.START) > 0 && Double.compare(value, this.END) < 0) {

        return Integer.toString(values.size());
    }
}
