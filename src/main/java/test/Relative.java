package test;

import java.util.Scanner;

/**
 * 并查集应用：亲戚问题
 * 来源：[洛谷P1551](https://www.luogu.com.cn/problem/P1551)
 *
 * @author wangbo
 * @date 2021/10/18 16:34
 */
public class Relative {
    private static int[] fa, rank;

    public static void main(String[] args) {
        // int n, m, p, x, y;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();

        init(n);
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            merge(x, y);
        }
        for (int i = 0; i < p; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(find(x) == find(y) ? "Yes" : "No");
        }
    }

    private static void init(int n) {
        fa = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }

    private static int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }

    private static void merge(int i, int j) {
        int x = find(i), y = find(j);
        if (rank[x] <= rank[y])
            fa[x] = y;
        else
            fa[y] = x;
        if (rank[x] == rank[y] && x != y)
            rank[y]++;
    }
}
