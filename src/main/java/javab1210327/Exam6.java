package javab1210327;

import java.util.Scanner;

public class Exam6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        for (int x = 0; x < total; x++) {
            StringBuilder sb = new StringBuilder();
            int num = sc.nextInt();
            for (int y = 2; y <= num / 2; y++) {
                while (num % y == 0) {
                    sb.append(y + "*");
                    num /= y;
                }
            }
            stringBuilder.append(sb.substring(0, sb.length() - 1) + "\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
