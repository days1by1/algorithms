package year2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestS3E5 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(in.readLine());
            long res = 0;
            if (n <= 6) {
                res = 15;
            } else {
                long remainder = n % 6;
                if (remainder == 0) {
                    res = n / 6 * 15;
                } else if (remainder <= 2) {
                    res = (n / 6 - 1) * 15 + 20;
                    // res = n / 6 * 15 + 5;
                } else if (remainder <= 4) {
                    res = (n / 6 - 1) * 15 + 25;
                    // res = n / 6 * 15 + 10;
                } else {
                    res = (n / 6 + 1) * 15;
                    // res = n / 6 * 15 + 15;
                }
            }
            System.out.println(res);
        }
    }
}
