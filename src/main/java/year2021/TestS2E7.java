package year2021;

import java.util.Scanner;

public class TestS2E7 {
    static int MAX = 200005;
    static int n, k, cnt;
    static int[] num = new int[MAX];
    static int[] d = new int[MAX];
    static int[] head = new int[MAX];
    static int[] Next = new int[MAX * 2];
    static int[] vet = new int[MAX * 2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int x, y;
        for (int i = 1; i <= k * 2; i++) {
            x = sc.nextInt();
            num[x] = 1;
        }
        for (int i = 1; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            add(x, y);
            add(y, x);
        }

        dfs(1, 0);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = head[i]; j != 0; j = Next[j]) {
                int v = vet[j];
                if (d[v] < d[i]) {
                    v = i;
                }
                ans += (long)Math.min(k - num[v], num[v]);
            }
        }
        System.out.println(ans / 2);
    }


    static void add(int x, int y) {
        cnt++;
        Next[cnt] = head[x];
        head[x] = cnt;
        vet[cnt] = y;
    }

    static void dfs(int x, int fa) {
        d[x] = d[fa] + 1;
        for (int i = head[x]; i != 0; i = Next[i]) {
            int v = vet[i];
            if (v == fa) continue;
            dfs(v, x);
            num[x] += num[v];
        }
    }
}
