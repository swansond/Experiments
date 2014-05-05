package coins;

/**
 * Created by davidswanson on 4/29/14.
 */
public class Coin {
    private static int[] values = new int[] {200, 100, 50, 20, 10, 5, 2, 1};
    private static int   count  = 0;


    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        compute(200, 0, new int[8]);
        Long end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println("took " + (end - start) + " milliseconds");
    }

    private static void compute(int remaining, int nextCoin, int[] counts) {
        if (remaining == 0) {
            count++;
        } else {
            if (values[nextCoin] <= remaining) {
                counts[nextCoin] += 1;
                compute(remaining - values[nextCoin], nextCoin, counts);
                counts[nextCoin] -= 1;
            }
            if (nextCoin + 1 < values.length) {
                compute(remaining, nextCoin + 1, counts);
            }
        }
    }
}
