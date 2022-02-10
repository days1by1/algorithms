package year2021;

import java.util.Arrays;
import java.util.Scanner;

public class TestS2E3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int b = sc.nextInt();
        int mod = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int[][] f = new int[m + 1][b + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = a[i]; k <= b; k++) {
                    f[j][k] += f[j - 1][k - a[i]];
                    f[j][k] %= mod;
                }
            }
        }

        // for (int i = 0; i < f.length; i++) {
        //     System.out.println(Arrays.toString(f[i]));
        // }

        int result = 0;
        for (int i = 0; i <= b; i++) {
            result += f[m][i];
            result %= mod;
        }

        System.out.println(result);
    }
}
