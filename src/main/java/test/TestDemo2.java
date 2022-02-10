package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class TestDemo2 {

    public static void main(String[] args) throws IOException {
        int words = Reader.nextInt();
        int[] indexs = new int[words + 1];
        int[] costs = new int[words + 1];
        int groups = Reader.nextInt();
        int msgLength = Reader.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= words; i++) {
            map.put(Reader.next(), i);
            indexs[i] = i;
        }
        for (int i = 1; i <= words; i++) {
            costs[i] = Reader.nextInt();
        }
        for (int i = 0; i < groups; i++) {
            String[] str = Reader.nextLine().split(" ");
            int count = Integer.parseInt(str[0]);
            int temp = Integer.parseInt(str[1]);
            for (int j = 2; j <= count; j++) {
                int idx = Integer.parseInt(str[j]);
                costs[temp] = Math.min(costs[temp], costs[idx]);
                indexs[idx] = temp;
            }
        }
        long res = 0;
        for (int i = 0; i < msgLength; i++) {
            res += costs[indexs[map.get(Reader.next())]];
        }
        System.out.println(res);
    }

    static class Reader {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");

        static String nextLine() throws IOException {
            return reader.readLine();
        }

        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}