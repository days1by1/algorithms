package year2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestS3E7 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] s1 = in.readLine().split(" ");
            String[] s2 = in.readLine().split(" ");

            // 自己写的快速排序，超时
            /*int[][] a = new int[2][n];
            for (int i = 0; i < n; i++) {
                a[0][i] = Integer.parseInt(s1[i]);
                a[1][i] = Integer.parseInt(s2[i]);
            }
            quickSort(a, 0, n - 1);
            int sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (sum + a[1][i] < a[0][i]) {
                    sum += a[1][i];
                } else {
                    if (sum < a[0][i]) {
                        sum = a[0][i];
                    }
                    break;
                }
            }*/

            // 使用Arrays.sort()
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = Integer.parseInt(s1[i]);
                a[i][1] = Integer.parseInt(s2[i]);
            }
            Arrays.sort(a, (x, y) -> x[0] - y[0]);
            int sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (sum + a[i][1] < a[i][0]) {
                    sum += a[i][1];
                } else {
                    if (sum < a[i][0]) {
                        sum = a[i][0];
                    }
                    break;
                }
            }

            System.out.println(sum);
        }
    }

    public static void quickSort(int[][] a, int low, int high) {
        int mid;
        if (low < high) {
            mid = partition(a, low, high);
            quickSort(a, low, mid - 1);
            quickSort(a, mid + 1, high);
        }
    }

    public static int partition(int[][] a, int low, int high) {
        int i = low, j = high, pivot = a[0][low];   // pivot可以选择首、尾、中间三个位置的数的中间值

        while (i < j) {
            while (i < j && a[0][j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(a, i++, j);
            }
            while (i < j && a[0][i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(a, i, j--);
            }
        }

        return i;
    }

    /**
     * 交换两个变量的值
     */
    public static void swap(int[][] a, int i, int j) {
        // 中间变量的方法
        int temp = a[0][i];
        a[0][i] = a[0][j];
        a[0][j] = temp;
        temp = a[1][i];
        a[1][i] = a[1][j];
        a[1][j] = temp;

        // 异或的方法
        /*a[0][i] = a[0][i] ^ a[0][j];
        a[0][j] = a[0][i] ^ a[0][j];
        a[0][i] = a[0][i] ^ a[0][j];
        a[1][i] = a[1][i] ^ a[1][j];
        a[1][j] = a[1][i] ^ a[1][j];
        a[1][i] = a[1][i] ^ a[1][j];*/
    }
}
