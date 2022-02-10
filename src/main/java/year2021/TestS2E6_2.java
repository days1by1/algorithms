package year2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestS2E6_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (long j = 1; j <= arr[i] * 2; j *= 2) {
                if (j <= arr[i]) {
                    continue;
                }
                ans += map.getOrDefault((int)j - arr[i], 0);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(ans);
    }
}
