package test;

/**
 * 并查集
 *
 * @author wangbo
 * @since 2021/10/18 16:17
 */
public class UnionFind {
    static int[] fa;

    public static void main(String[] args) {

    }

    public static void init(int n) {
        for (int i = 1; i <= n; i++)
            fa[i] = i;
    }

    public static int find(int x) {
        if (fa[x]==x)
            return x;
        else
            return find(fa[x]);
    }

    public static void merge(int i, int j){
        fa[find(i)] = find(j);
    }

}
