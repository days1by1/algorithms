package year2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestS3E7_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] s1 = in.readLine().split(" ");
            String[] s2 = in.readLine().split(" ");

            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = Integer.parseInt(s1[i]);
                a[i][1] = Integer.parseInt(s2[i]);
            }
            Arrays.sort(a, (x, y) -> x[0] - y[0]);  // 对ai升序排序

            // 正向思维
            long sum = 0;
            for(int i=0; i<n; i++){
                sum += a[i][1];
            }
            long ans = sum;
            for(int i=0; i<n; i++) {
                sum -= a[i][1];
                ans = Math.min(ans, Math.max(sum, a[i][0]));
            }

            // 逆向思维
            /*int sum = 0, ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (sum + a[i][1] < a[i][0]) {
                    sum += a[i][1];
                    ans = sum;
                } else {
                    ans = Math.max(sum, a[i][0]);
                    break;
                }
            }*/

            System.out.println(ans);
        }
    }
}
