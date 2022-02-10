package year2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class TestS2E6 {

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        //
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = sc.nextInt();
        // }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] temp = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        // 方法1：遍历
        // long count = 0;
        // for (int i = 0; i < n - 1; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int sum = arr[i] + arr[j];
        //         while (sum % 2 == 0 && sum != 0) {
        //             sum /= 2;
        //         }
        //         if (sum == 1) {
        //             count++;
        //         }
        //     }
        // }
        //
        // System.out.println(count);


        // 方法2：枚举
        Arrays.sort(arr);
        long ans = 0;
        int[] power = new int[31];
        for (int i = 0; i < power.length; i++) {
            power[i] = 1 << i;
        }

        // 并不需要对2的所有次幂进行枚举，只需要枚举到比【最大数】大的【最小的2的幂】
        int endIndex = power.length - 1;
        for (int i = 0; i < power.length; i++) {
            if (power[i] > arr[n - 1]) {
                endIndex = i;
                break;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= endIndex; j++) {
                if (power[j] > arr[i]) {
                    int key = power[j] - arr[i];
                    for (int k = i + 1; k < n; k++) {
                        if (key == arr[k]) {
                            ans++;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
