package pandigital;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by davidswanson on 4/29/14.
 */
public class PandigitalFinder {
    private static Set<Integer> products = new HashSet<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                if (isPandigital(i, j)) {
                    products.add(i * j);
                }
            }
        }
        int result = products.parallelStream().reduce(Integer::sum).get();
        long end = System.currentTimeMillis();
        System.out.println(result + " in " + (end - start) + " milliseconds");
    }

    private static boolean isPandigital(int a, int b) {
        Set<Integer> digits = new HashSet<>();
        if (isPandigital(concat(a, b), digits)) {
            for (int x : new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}) {
                if (!digits.contains(x)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static long concat(int a, int b) {
        return Long.parseLong(String.valueOf(a) + b + a * b);
    }

    private static boolean isPandigital(long x, Set<Integer> digits) {
        while (x != 0) {
            if (x % 10 == 0 || !digits.add((int) (x % 10))) {
                return false;
            }
            x /= 10;
        }
        return true;
    }
}
