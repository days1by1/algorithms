package leetcode.daily_question;

/**
 * 2923. 找到冠军 I
 * 难度：简单
 *
 * @author wangbo
 * @created 2024年04月12日 21:56
 */
public class No2923_FindChampion {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(findChampion(grid));
    }

    public static int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int count0 = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count0++;
                if (count0 > 1) break;
            }
            if (count0 == 1) return i;
        }
        return 0;
    }

}
