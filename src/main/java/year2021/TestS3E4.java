package year2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestS3E4 {

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int q = Integer.parseInt(sc.nextLine());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(in.readLine());
        while (q-- > 0) {
            // String[] s = sc.nextLine().split(" ");
            String[] s = in.readLine().split(" ");
            int c = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);

            if (c > 0 && m > 0) {
                if (c != m) {
                    int min = Math.min(c, m);
                    int temp = Math.abs(c - m) + x;
                    if (temp >= min) {
                        System.out.println(min);
                    } else {
                        System.out.println((c + m + x) / 3);
                    }
                } else {
                    if (x >= c) {
                        System.out.println(c);
                    } else {
                        System.out.println((c + m + x) / 3);
                    }
                }
            } else {
                System.out.println(0);
            }
        }
    }
}
