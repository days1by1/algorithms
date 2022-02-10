package year2021;

import java.util.Arrays;
import java.util.Scanner;

public class TestS2E4 {
    static int n;
    static int m;
    static final int INF = 65535;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] map = new int[n][n];
        int[][] map2 = new int[n][n];

        // 准备map：铁路地图
        while (m-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            map[i - 1][j - 1] = 1;
            map[j - 1][i - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && map[i][j] == 0) {
                    map[i][j] = INF;
                }
            }
        }
        // 准备map2：公路地图
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    map2[i][j] = INF;
                }
                if (map[i][j] == INF) {
                    map2[i][j] = 1;
                }
            }
        }

        int dist = 0;
        if (map[0][n - 1] == 1) {
            dist = dijkstra(map2, 0);
        } else {
            dist = dijkstra(map, 0);
        }
        if (dist != INF) {
            System.out.println(dist);
        } else {
            System.out.println(-1);
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        // System.out.println("------------");
        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(map2[i]));
        // }
    }

    private static int dijkstra(int[][] map, int u) {
        boolean[] flag = new boolean[n];
        int[] dist = Arrays.copyOf(map[u], map[u].length);
        int[] pre = new int[n];

        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) {
                pre[i] = -1;
            } else {
                pre[i] = u;
            }
        }
        dist[u] = 0;
        flag[u] = true;

        for (int i = 0; i < n; i++) {
            int min = INF, t = u;
            for (int j = 0; j < n; j++) {
                if (!flag[j] && dist[j] < min) {
                    t = j;
                    min = dist[j];
                }
            }
            if (t == u) {
                break;
            }
            flag[t] = true;
            for (int j = 0; j < n; j++) {
                if (!flag[j] && dist[t] + map[t][j] < dist[j]) {
                    dist[j] = dist[t] + map[t][j];
                    pre[j] = t;
                }
            }
        }

        return dist[n - 1];
    }
}
