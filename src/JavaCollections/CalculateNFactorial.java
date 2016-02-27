package JavaCollections;

/**
 * Created by marin on 2/27/16.
 *
 * Write a program that recursively calculates factorial.
 */
public class CalculateNFactorial {

    private static long nFactorial(long n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * nFactorial(n - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(nFactorial(5));

    }
}
