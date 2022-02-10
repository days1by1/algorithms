package year2021;

import java.util.HashMap;
import java.util.Scanner;

public class TestS2E6_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res = 0;

        // 邓密文版本
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long a = sc.nextInt();
            for (long c = 1; c <= (1L << 31); c <<= 1)
                res += map.getOrDefault(c - a, 0);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // 采用HashMap<Integer, Integer> map的写法，则变量a为int型，此时c-a需要强转为int型，否则会有截断误差
        /*HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            for (long c = 1; c <= (1L << 31); c <<= 1)
                res += map.getOrDefault((int)c - a, 0);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }*/

        // 控制左移次数为30
        /*HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            // 此处由于1<<31=-2147483648，而1L<<31=2147483648，会造成死循环
            // for (int c = 1; c <= (1L << 30); c <<= 1)
            //     res += map.getOrDefault(c - a, 0);
            // 方法1：变量c采用long型，并把c-a强转为int（否则会产生截断误差）
            for (long c = 1; c <= (1L << 30); c <<= 1)
                res += map.getOrDefault((int)(c - a), 0);
            // 方法2：控制变量c的左移次数
            // for (int c=1, j=0; j<30; j++) {
            //     c <<= 1;
            //     res += map.getOrDefault(c - a, 0);
            // }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }*/

        System.out.println(res);
    }
}
