package year2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestS3E6 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] strings = in.readLine().split(" ");
            int count = 0;
            for (String s : strings) {
                if ("1".equals(s)) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == n) {
                // 由于是否都为1的情况和前缀1的情况相反，故这里给count++，统一输出格式
                count++;
            }
            System.out.println((count & 1) == 1 ? "Second" : "First");
        }
    }
}
