package test;

import java.util.Scanner;

/**
 * @author wangbo
 * @date 2021/10/19 14:09
 */
public class Relative2 {

    private static int[] parent, dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        parent = new int[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(x, y);
        }
        for (int i = 0; i < p; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(find(x) == find(y) ? "Yes" : "No");
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        // return parent[x] = find(parent[x]); // 路径压缩
        return find(parent[x]);
    }

    private static void union(int x, int y) {
        int x_root = find(x);
        int y_root = find(y);
        if (dist[x_root] > dist[y_root]) {
            parent[y_root] = x_root;
            // dist[x_root]++;
        }
        else if (dist[y_root] > dist[x_root]) {
            parent[x_root] = y_root;
            // dist[y_root]++;
        }
        else {
            parent[x_root] = y_root;
            dist[y_root]++;
        }
    }
}
