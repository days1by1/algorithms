package year2021;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TestS2E2_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();

        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        while (N-- > 0) {
            xs.add(sc.nextInt());
            ys.add(sc.nextInt());
        }

        Set<BigDecimal> slopes = new HashSet<>();
        // 位于垂直于x轴的直线上的点的个数
        int verticalCount = 0;
        for (int i = 0; i < xs.size(); i++) {
            if (xs.get(i) == x0) {
                verticalCount++;
            } else {
                double slope = (ys.get(i) - y0) * 1.0 / (xs.get(i) - x0);
                slopes.add(new BigDecimal(slope));
            }
        }

        int result = verticalCount > 0 ? slopes.size() + 1 : slopes.size();
        System.out.println(result);
    }
}
