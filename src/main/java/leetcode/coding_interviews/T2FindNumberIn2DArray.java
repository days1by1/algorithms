package leetcode.coding_interviews;

/**
 * 注意：要排除二维数组是[]或[[]]的情况，否则会下标越界
 * <p>
 * 如果二维数组是严格递增的（即除了从左到右、从上到下递增外，下一行的数要大于上一行的数），
 * 则可以使用完整的二分找法——先行二分，再列二分。
 *
 * @author wangbo
 * @since 2021/11/28 12:43
 */
public class T2FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        // int[][] matrix = new int[1][0];
        // int[][] matrix = new int[0][0];

        // 严格递增的二维数组
        /*int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {16, 25, 28, 32, 39},
                {43, 46, 49, 50, 52},
                {53, 54, 55, 57, 58},
                {59, 60, 61, 66, 70}
        };*/
        int target = 5;
        System.out.println(findNumberIn2DArray(matrix, target));
    }

    // 从右上角开始找
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean flag = false;
        // 排除二维数组是[]或[[]]的情况，以免下标越界
        if (matrix.length == 0 || matrix[0].length == 0) {
            return flag;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length) {
            if (matrix[i][j] == target) {
                flag = true;
                break;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                int left = 0, right = matrix[0].length - 1;
                while (left <= right) {
                    j = (left + right) / 2;
                    if (matrix[i][j] == target) {
                        flag = true;
                        break;
                    } else if (matrix[i][j] > target) {
                        right = j - 1;
                    } else {
                        left = j + 1;
                    }
                }
                i++;
            }
        }
        return flag;
    }

    // 严格递增的二维数组适用的二分查找法
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        boolean flag = false;

        int j = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;
        while (up < down) {
            int i = (up + down) / 2;
            if (matrix[i][j] == target) {
                flag = true;
                break;
            } else if (matrix[i][j] > target) {
                down = i;
            } else {
                up = i + 1;
            }
        }

        if (up == down) {
            int left = 0, right = matrix[0].length - 1;
            while (left <= right) {
                j = (left + right) / 2;
                if (matrix[up][j] == target) {
                    flag = true;
                    break;
                } else if (matrix[up][j] > target) {
                    right = j - 1;
                } else {
                    left = j + 1;
                }
            }
        }

        return flag;
    }
}
