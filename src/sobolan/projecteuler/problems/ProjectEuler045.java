package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:
 * Triangle: T(n)=n(n+1)/2           1, 3, 6, 10, 15, ...
 * Pentagonal: P(n)=n(3n−1)/2        1, 5, 12, 22, 35, ...
 * Hexagonal: H(n)=n(2n−1)           1, 6, 15, 28, 45, ...
 * It can be verified that T(285) = P(165) = H(143) = 40755.
 * Find the next triangle number that is also pentagonal and hexagonal.
 */
public class ProjectEuler045 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        /**
         * we start from the indexes provided by the problem statement
         */
        int tIndex = 285, pentIndex = 165, hexIndex = 143;

        /**
         * we start with one step further
         */
        hexIndex++;

        long hexagonal = this.getHexagonal(hexIndex);
        long triangle = this.getTriangle(tIndex);
        long pentagonal = this.getPentagonal(pentIndex);

        /**
         * we compare everything against the hexagonal number because, given it's formula, it grows the fastest
         */
        while (hexagonal > triangle || hexagonal > pentagonal) {
            if (hexagonal > triangle) {
                tIndex++;
                triangle = this.getTriangle(tIndex);
            }

            if (hexagonal > pentagonal) {
                pentIndex++;
                pentagonal = this.getPentagonal(pentIndex);
            }

            if (hexagonal < triangle || hexagonal < pentagonal) {
                hexIndex++;
                hexagonal = this.getHexagonal(hexIndex);
            }
        }

        return String.format("T(%d) = P(%d) = H(%d) = %d", tIndex, pentIndex, hexIndex, hexagonal);
    }

    private long getTriangle(long n)
    {
        return (n * n + n) / 2;
    }

    private long getPentagonal(long n)
    {
        return (3 * n * n - n) / 2;
    }

    private long getHexagonal(long n)
    {
        return 2 * n * n - n;
    }
}
