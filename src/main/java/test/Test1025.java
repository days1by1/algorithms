package test;

import java.util.Scanner;

public class Test1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        maxLength(arr);
    }

    private static void maxLength(int[] arr) {
        if (arr.length == 1 || arr.length == 2) {
            System.out.println(arr.length);
        } else {
            int maxLen = 0, len = 2;
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] == arr[i - 1] + arr[i - 2]) {
                    len++;
                } else {
                    maxLen = maxLen > len ? maxLen : len;
                    len = 2;
                }
            }
            maxLen = maxLen > len ? maxLen : len;
            System.out.println(maxLen);
        }
    }
}
