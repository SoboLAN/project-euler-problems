package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are: 012 021 102 120 201 210
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class ProjectEuler24 extends AbstractExecutableProblem
{
    private final int LIMIT = 1 * 1000 * 1000;
    private final int[] digits = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final int N = digits.length;

    @Override
    public String getResult()
    {
        for (int count = 1; count <= this.LIMIT - 1; count++) {
            this.nextPermutation();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.N; i++) {
            sb.append(Integer.toString(this.digits[i]));
        }

        return sb.toString();
    }

    private void nextPermutation ()
    {
        int i = this.N - 1;
        while (this.digits[i - 1] >= this.digits[i]) {
            i--;
        }

        int j = this.N;
        while (this.digits[j - 1] <= this.digits[i - 1]) {
            j--;
        }

        int ax = this.digits[i - 1];
        this.digits[i - 1] = this.digits[j - 1];
        this.digits[j - 1] = ax;

        i++;
        j = this.N;

        while (i < j) {
            ax = this.digits[i - 1];
            this.digits[i - 1] = this.digits[j - 1];
            this.digits[j - 1] = ax;

            i++;
            j--;
        }
    }
}
