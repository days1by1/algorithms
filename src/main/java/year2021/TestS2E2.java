package year2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestS2E2 {

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

        int count = 0;
        // 标记与(x0, y0)在同一条垂直于x轴的直线上的点是否找出来
        boolean vertical = false;
        while (xs.size() > 0) {
            int size = xs.size();
            if (vertical) {
                // 标记是否计算了斜率
                boolean flag = false;
                double slope = 0;
                for (int i = 0; i < xs.size(); i++) {
                    if (!flag) {
                        // 注意：此处要乘以1.0，才能得到浮点数结果，否则整数截断后会导致斜率是否相等的判断出现错误
                        slope = (ys.get(i) - y0) * 1.0 / (xs.get(i) - x0);
                        xs.remove(i);
                        ys.remove(i);
                        i--;
                        flag = true;
                    } else {
                        if (slope == (ys.get(i) - y0) * 1.0 / (xs.get(i) - x0)) {
                            xs.remove(i);
                            ys.remove(i);
                            i--;
                        }
                    }
                }
            } else {
                for (int i = 0; i < xs.size(); i++) {
                    if (xs.get(i) == x0) {
                        xs.remove(i);
                        ys.remove(i);
                        i--;
                    }
                }
                vertical = true;
            }

            if (xs.size() < size) {
                count++;
            }
        }

        System.out.println(count);
    }
}
