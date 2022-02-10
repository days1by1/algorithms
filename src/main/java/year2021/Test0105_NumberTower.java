package year2021;

import java.util.Scanner;

public class Test0105_NumberTower {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入塔的层数：");
        int n = sc.nextInt();
        int[][] data = new int[n][n];
        System.out.println("输入塔的节点数据（第i层有i个节点）:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                data[i][j] = sc.nextInt();
            }
        }

        int result = numberTower(data);
        System.out.println("数字之和最大值：" + result);
    }

    private static int numberTower(int[][] data) {
        int n = data.length;
        int[][] dp = new int[n][n];
        // 第一种求路径的方法
        // int[][] path = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = data[n - 1][i];
        }
        // 第一种求路径的方法的计算方式
        // for (int i = n - 2; i >= 0; i--) {
        //     for (int j = 0; j <= i; j++) {
        //         if (dp[i + 1][j] > dp[i + 1][j + 1]) {
        //             dp[i][j] = dp[i + 1][j] + data[i][j];
        //             path[i][j] = j;
        //         } else {
        //             dp[i][j] = dp[i + 1][j + 1] + data[i][j];
        //             path[i][j] = j + 1;
        //         }
        //     }
        // }

        // 第二种求路径的方法的计算方式
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + data[i][j];
            }
        }

        System.out.print("数字之和最大时的路径：" + data[0][0]);
        // 第一种求路径的方法的输出方式
        // int j = path[0][0];
        // for (int i = 1; i < n; i++) {
        //     System.out.print("->" + data[i][j]);
        //     j = path[i][j];
        // }

        // 第二种求路径的方法的输出方式
        int j = 0;
        for (int i = 1; i < n; i++) {
            int nodeValue = dp[i - 1][j] - data[i - 1][j];
            if (nodeValue == dp[i][j + 1]) {
                j++;
            }
            System.out.print("->" + data[i][j]);
        }
        System.out.println();

        return dp[0][0];
    }
}
