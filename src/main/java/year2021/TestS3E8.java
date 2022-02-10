package year2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestS3E8 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] sx = in.readLine().split(" ");
        String[] sy = in.readLine().split(" ");
        int[] x = new int[n], y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(sx[i]);
            y[i] = Integer.parseInt(sy[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            Arrays.sort(y, 0, i + 1);
            List<Integer> sums = new ArrayList<>();
            if (y[0] > 1) {
                int sum = 0;
                for (int j = 0; j < y[0] - 1; j++) {
                    sum += x[j];
                }
                sums.add(sum);
            }
            if (y[i] < n) {
                int sum = 0;
                for (int j = y[i]; j < n; j++) {
                    sum += x[j];
                }
                sums.add(sum);
            }
            for (int j = 0; j < i; j++) {
                if (y[j + 1] - y[j] >= 2) {
                    int sum = 0;
                    for (int k = y[j]; k < y[j + 1] - 1; k++) {
                        sum += x[k];
                    }
                    sums.add(sum);
                }
            }
            int max = sums.stream().mapToInt(Integer::intValue).max().getAsInt();
            System.out.println(max);
        }
        System.out.println(0);
    }
}
