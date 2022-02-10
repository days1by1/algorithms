package year2021;

import java.util.Scanner;

public class Test0109 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] s = sc.nextLine().split(" ");
            int l = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            long m$$ = Long.parseLong(s[2]);

            int min = l - r;
            int max = r - l;

            for (int a = l; a <= r; a++) {
                if (m$$ % a <= max && m$$ >= a) {
                    System.out.printf("%d %d %d\n", a, m$$ % a + l, l);
                    break;
                } else if (m$$ % a - a >= min) {
                    System.out.printf("%d %d %d\n", a, m$$ % a - a + r, r);
                    break;
                }
                /*if (m$$ % a - a >= min) {
                    System.out.printf("%d %d %d\n", a, m$$ % a - a + r, r);
                    break;
                } else if (m$$ % a <= max) {
                    System.out.printf("%d %d %d\n", a, m$$ % a + l, l);
                    break;
                }*/
            }
        }
    }
}

abstract class P3CTest{}
