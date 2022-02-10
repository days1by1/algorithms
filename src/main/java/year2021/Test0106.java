package year2021;

import java.util.Scanner;

public class Test0106 {
    static char[][] map;
    static boolean[][] isVisited;
    static int n, m;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] n_m = sc.nextLine().split(" ");
        n = Integer.parseInt(n_m[0]);
        m = Integer.parseInt(n_m[1]);
        map = new char[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        // System.out.println(n + "---" + m);
        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j, -1, -1);
                }
                if (flag) {
                    break;
                }

            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void dfs(int i, int j, int fx, int fy) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        char c = map[i][j];
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == c) {
                if (x == fx && y == fy) {
                    continue;
                }
                if (isVisited[x][y]) {
                    flag = true;
                    // break;
                    return;
                }
                isVisited[x][y] = true;
                dfs(x, y, i, j);
            }
        }
    }
}
