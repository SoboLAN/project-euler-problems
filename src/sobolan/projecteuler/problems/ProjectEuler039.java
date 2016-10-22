package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c},
 * there are exactly three solutions for p = 120.
 * {20,48,52}, {24,45,51}, {30,40,50}
 * For which value of p <= 1000, is the number of solutions maximised?
 */
public class ProjectEuler039 extends AbstractExecutableProblem
{
    private final int P = 1000;

    @Override
    public String getResult()
    {
        int[] solutions = new int[this.P + 1];

        for (int a = 1; a < this.P; a++) {
            for (int b = 1; b < a; b++) {
                for (int c = 1; c < this.P - a - b; c++) {
                    if (a * a + b * b == c * c) {
                        solutions[a + b + c]++;
                    }
                }
            }
        }

        int maxNrSolutions = solutions[0], maxP = 0;
        for (int i = 1; i < this.P + 1; i++) {
            if (solutions[i] > maxNrSolutions) {
                maxNrSolutions = solutions[i];
                maxP = i;
            }
        }

        return String.format("%d (%d solutions)", maxP, maxNrSolutions);
    }
}
