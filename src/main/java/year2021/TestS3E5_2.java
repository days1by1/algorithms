package year2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestS3E5_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(in.readLine());
            long res = 0;
            if (n % 6 == 0) {
                res = n / 6 * 15;
            } else if (n % 8 == 0) {
                res = n / 8 * 20;
            } else if (n % 10 == 0) {
                res = n / 10 * 25;
            } else if (n < 6) {
                res = 15;
            } else if (n < 8) {
                res = 20;
            } else if (n < 10) {
                res = 25;
            } else {
                long remainder = n % 10;
                if (remainder == 1 || remainder == 2) {
                    res = (n / 10 - 1) * 25 + 30;
                } else if (remainder == 3 || remainder == 4) {
                    res = (n / 10 - 1) * 25 + 35;
                } else if (remainder == 5 || remainder == 6) {
                    res = n / 10 * 25 + 15;
                } else if (remainder == 7 || remainder == 8) {
                    res = n / 10 * 25 + 20;
                } else {
                    res = n / 10 * 25 + 25;
                }
            }
            System.out.println(res);
        }
    }
}
