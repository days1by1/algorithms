package year2021;

import java.util.Scanner;

public class TestS2E1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] s1 = s.toCharArray();
        int m = sc.nextInt();
        while(m-->0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();

            int len = r - l + 1;
            l--;
            char[] s2 = String.valueOf(s1, l, len).toCharArray();
            k %= len;

            for(int i=0; i<k; i++) {
                s1[l+i] = s2[len-k+i];
            }
            for(int i=0; i<len-k; i++) {
                s1[l+k+i] = s2[i];
            }
        }

        System.out.println(String.valueOf(s1));
    }
}
