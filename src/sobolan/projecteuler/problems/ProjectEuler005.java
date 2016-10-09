package sobolan.projecteuler.problems;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class ProjectEuler005 extends AbstractExecutableProblem
{
    private final int NR_DIVISORS = 20;

    @Override
    public String getResult()
    {
        ArrayList<FactorRecord> records = new ArrayList<>();
        for (int i = 2; i <= NR_DIVISORS; i++) {
            records.add(new FactorRecord(i));
        }

        ArrayList<Integer> maximums = new ArrayList<>();
        for (int i = 0; i <= NR_DIVISORS; i++) {
            maximums.add(0);
        }

        for (FactorRecord record : records) {
            Iterator<Factor> it = record.getFactors();

            while (it.hasNext()) {
                Factor f = it.next();

                if (f.magnitude > maximums.get(f.factor)) {
                    maximums.set(f.factor, f.magnitude);
                }
            }
        }

        Integer result = 1;

        for (int i = 0; i <= NR_DIVISORS; i++) {
            if (maximums.get(i) == 0) {
                continue;
            }

            for (int j = 0; j < maximums.get(i); j++) {
                result *= i;
            }
        }

        return result.toString();
    }
}

class FactorRecord
{
    private int nr;
    private ArrayList<Factor> factors;

    FactorRecord (int nr)
    {
        this.nr = nr;
        this.factors = new ArrayList<>();
        factorize();
    }

    private void factorize()
    {
        int currentFactor = 2;
        int tmpNumber = this.nr;
        while (tmpNumber != 1) {
            if (tmpNumber % currentFactor == 0) {
                Factor f = new Factor();
                f.factor = currentFactor;
                f.magnitude = 0;

                while (tmpNumber % currentFactor == 0) {
                    tmpNumber /= currentFactor;
                    f.magnitude++;
                }

                this.factors.add(f);
            }

            currentFactor++;
        }
    }

    int getNumber()
    {
        return this.nr;
    }

    Iterator<Factor> getFactors()
    {
        return this.factors.iterator();
    }
}

class Factor
{
    int factor;
    int magnitude;
}