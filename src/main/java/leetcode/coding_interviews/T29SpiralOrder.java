package leetcode.coding_interviews;

import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 难度：简单
 *
 * @author wangbo
 * @since 2022年03月03日 10:09
 */
public class T29SpiralOrder {

    @Test
    public void test() {
        int[] ints = new int[0];
        System.out.println(Arrays.toString(ints));

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

    /**
     * 我的解答
     */
    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length, columns = 0;
        if (rows > 0) {
            columns = matrix[0].length;
        }
        int[] res = new int[rows * columns];
        if (res.length == 0) return res;

        // 方向控制：0-从左到右，1-从上到下，2-从右到左，3-从下到上
        int direction = 0;
        // 当前位置
        int i = 0, j = 0;
        // res索引
        int index = 0;
        while (rows != 0 && columns != 0) {
            // 从左到右
            if (direction == 0) {
                for (int k = 0; k < columns; k++) {
                    res[index++] = matrix[i][j++];
                }
                rows--;
                i++;
                j--;
                direction = 1;
                continue;
            }
            // 从上到下
            if (direction == 1) {
                for (int k = 0; k < rows; k++) {
                    res[index++] = matrix[i++][j];
                }
                columns--;
                i--;
                j--;
                direction = 2;
                continue;
            }
            // 从右到左
            if (direction == 2) {
                for (int k = 0; k < columns; k++) {
                    res[index++] = matrix[i][j--];
                }
                rows--;
                i--;
                j++;
                direction = 3;
                continue;
            }
            // 从下到上
            if (direction == 3) {
                for (int k = 0; k < rows; k++) {
                    res[index++] = matrix[i--][j];
                }
                columns--;
                i++;
                j++;
                direction = 0;
            }
        }

        return res;
    }
}
