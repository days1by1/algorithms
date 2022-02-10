package year2021;

import java.util.Arrays;
import java.util.Scanner;

public class TestS2E5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        // Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++) {
            // if (nums[i] > nums[i - 1]) {
            //     // dp[i] = dp[i - 1] + 1;
            //     dp[nums[i]] = dp[nums[i] - 1] + 1;
            // }
            dp[nums[i]] = dp[nums[i] - 1] + 1;
        }

        Arrays.sort(dp);
        System.out.println(n - dp[n]);
    }
}
