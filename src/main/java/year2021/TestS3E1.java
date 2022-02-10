package year2021;

import java.util.Scanner;

public class TestS3E1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            char[] s = sc.nextLine().toCharArray();
            int a = 0, b = 0, a1 = 0, b1 = 0;
            for (int i = 0; i < s.length; i++) {
                if (i % 2 == 0) {
                    if (s[i] == '1') {
                        a++;
                    } else if (s[i] == '?') {
                        a1++;
                    }
                } else {
                    if (s[i] == '1') {
                        b++;
                    } else if (s[i] == '?') {
                        b1++;
                    }
                }

                if (a + a1 > (10 - i) / 2 + b) {
                    System.out.println(i + 1);
                    break;
                }
                if (b + b1 > (9 - i) / 2 + a) {
                    System.out.println(i + 1);
                    break;
                }
                if (i == 9) {
                    System.out.println(10);
                }
            }
        }
    }
}
