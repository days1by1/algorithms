package year2021;

import java.util.Scanner;

public class Test0107_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 == 1) {
            int k = n / 2;
            long ans = 2 * (k + 1) * (k + 2);
            System.out.println(ans);
        } else {
            int k = n / 2 + 1;
            System.out.println(k * k);
        }
    }
}
