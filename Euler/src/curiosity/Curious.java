package curiosity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by davidswanson on 4/30/14.
 */
public class Curious {
    private static int last = 0;
    private static int[] fact = new int[10];

    public static void main(String[] args) {
        fact[0] = 1;
        for (int i = 1; i < 10; i++) {
            fact[i] = fact[i - 1] * i;
        }
        int sum = 0;
        for (int i = 3; i < 100000000; i++) {
            if (isCurious(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static boolean isCurious(int x) {
        List<Integer> digits = new ArrayList<>();
        int num = x;
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        int sum = 0;
        for (int s : digits) {
            sum += fact[s];
        }
        return x == sum;
    }
}
