package test;

import java.util.Arrays;

public class Test0624 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 6, 8, 9};
        System.out.println(Arrays.binarySearch(arr, 6));
        System.out.println(Arrays.binarySearch(arr, 1, 2, 5));
    }
}
