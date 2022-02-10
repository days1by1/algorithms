package year2021;

import java.util.Scanner;

public class Test0108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int k = Integer.parseInt(ss[1]);
        char[] num = sc.nextLine().toCharArray();

        if (n > 1) {
            int count = 0;
            if (num[0] > '1' && k > 0) {
                num[0] = '1';
                count++;
            }
            for (int i = 1; i < num.length && count < k; i++) {
                if (num[i] > '0') {
                    num[i] = '0';
                    count++;
                }
            }
        } else {
            if (k == 1) {
                num[0] = '0';
            }
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.print(num[i]);
        // }

        for(char ch : num) {
            System.out.print(ch);
        }
    }
}
