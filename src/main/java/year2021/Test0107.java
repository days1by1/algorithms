package year2021;

import java.util.Scanner;

public class Test0107 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 当n=1时会发生数组越界错误！
        // dp[1] = dp[2] = 4;
        dp[1] = 4;
        if(n >= 2) {
            dp[2] = 4;
        }

        if ((n & 1) == 1) {
            // 奇数
            for (int i = 3; i <= n; i += 2) {
                dp[i] = dp[i - 2] + 4 * (i + 1) / 2;
            }
        } else {
            // 偶数
            for (int i = 4; i <= n; i += 2) {
                dp[i] = dp[i - 4] + 4 * i / 2;
            }
        }

        System.out.println(dp[n]);
    }
}
