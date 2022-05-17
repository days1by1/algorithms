package quxue_algorithms.chapter4_dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最优三角剖分
 *
 * @author wangbo
 * @since 2022年05月05日 13:33
 * <p>
 * 6
 * <p>
 * 0 2 3 1 5 6
 * <p>
 * 2 0 3 4 8 6
 * <p>
 * 3 3 0 10 13 7
 * <p>
 * 1 4 10 0 12 5
 * <p>
 * 5 8 13 12 0 3
 * <p>
 * 6 6 7 5 3 0
 */
public class Demo7MinWeightTriangulation {

    static int n;
    static double[][] g;
    static double[][] m;
    static int[][] s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入顶点的个数n：");
        n = sc.nextInt();
        g = new double[n][n];
        m = new double[n][n];
        s = new int[n][n];
        System.out.println("请依次输入各顶点的连接权值：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextDouble();
            }
        }

        // 顶点序号从0开始
        // minWeightTriangulation();
        // print(1, n - 1);

        // 顶点序号从1开始
        minWeightTriangulation2();
        print2(0, n - 1);

        System.out.println("==========");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
        System.out.println("==========");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(s[i]));
        }
    }

    /**
     * 最优三角剖分(顶点序号从0开始)
     */
    public static void minWeightTriangulation() {
        // 初始化，Java程序可以忽略
        /*for (int i = 1; i < n; i++) {
            m[i][i] = 0;
            s[i][i] = 0;
        }*/
        for (int d = 2; d < n; d++) {
            // d为i到j的规模，d=2时，实际上是三个点
            // 因为我们的m[i][j]表示的是{vi-1, vi, vj}
            for (int i = 1; i < n - d + 1; i++) {
                int j = i + d - 1;
                m[i][j] = Double.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    double temp = m[i][k] + m[k + 1][j] + g[i - 1][k] + g[k][j] + g[i - 1][j];
                    if (temp < m[i][j]) {
                        m[i][j] = temp;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    /**
     * 输出最优解(顶点从0开始)
     */
    public static void print(int i, int j) {
        if (i == j) return;
        if (s[i][j] > i) {
            System.out.println("v" + (i - 1) + "v" + s[i][j]);
        }
        if (j > s[i][j] + 1) {
            System.out.println("v" + s[i][j] + "v" + j);
        }
        print(i, s[i][j]);
        print(s[i][j] + 1, j);
    }

    /**
     * 最优三角剖分(顶点序号从1开始)
     */
    public static void minWeightTriangulation2() {
        // 初始化，Java程序可省略
        /*for (int i = 0; i < n; i++) {
            for (int j = i; j <= i + 1; j++) {
                m[i][j] = 0;
                s[i][j] = 0;
            }
        }*/
        for (int d = 3; d <= n; d++) {
            for (int i = 0; i < n - d + 1; i++) {
                int j = i + d - 1;
                m[i][j] = Double.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    double temp = m[i][k] + m[k][j] + g[i][k] + g[k][j] + g[i][j];
                    if (temp < m[i][j]) {
                        m[i][j] = temp;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    /**
     * 输出最优解(顶点从1开始)
     */
    public static void print2(int i, int j) {
        if (i + 1 == j) return;
        if (s[i][j] > i + 1) {
            System.out.println("v" + (i + 1) + "v" + (s[i][j] + 1));
        }
        if (j > s[i][j] + 1) {
            System.out.println("v" + (s[i][j] + 1) + "v" + (j + 1));
        }
        print2(i, s[i][j]);
        print2(s[i][j], j);
    }
}
