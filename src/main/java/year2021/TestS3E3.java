package year2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestS3E3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int s = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int i = 1;
            s -= i;
            list.add(i);
            while (s != 0) {
                if (s >= i + 2) {
                    i += 2;
                    s -= i;
                    list.add(i);
                } else if (s == i + 1) {
                    i += 1;
                    s -= i;
                    list.add(i);
                } else if (list.contains(s) || list.contains(s - 1) || list.contains(s - 2)) {
                    i = s;
                    s -= i;
                    list.add(i);
                }
            }

            // System.out.println(list);
            System.out.println(list.size());
        }
    }
}
