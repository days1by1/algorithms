package javab1210327;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    sb.append(i + "*");
                    n /= i;
                }
            }
            if (sb.length() > 1) {
                System.out.println(sb.substring(0, sb.length() - 1));
            } else {
                System.out.println(sb.toString());
            }
        }
    }
}
