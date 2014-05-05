package digitfractions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidswanson on 4/30/14.
 */
public class DigitCancel {
    public static void main(String[] args) {
        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < i; j++) {
                for (double x : breakdown(j, i)) {
                    if (x - (j * 1.0 / i) < .0001 && (j * 1.0 / i) - x < .0001) {
                        System.out.println(j + " / " + i);
                    }
                }
            }
        }
    }

    public static List<Double> breakdown(int a, int b) {
        List<Double> output = new ArrayList<>();
        int f = a / 10;
        int g = a % 10;
        int h = b / 10;
        int i = b % 10;
        if (f == i && h != 0) {
            output.add(g * 1.0 / h);
        }
        if (g == h && i != 0) {
            output.add(f * 1.0 / i);
        }
        return output;
    }
}
