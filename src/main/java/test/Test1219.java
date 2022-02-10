package test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test1219 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        String maxString = sc.next();
//        String minString = sc.next();
        String maxString = Reader.nextLine();
        String minString = Reader.nextLine();

        int count = 0;
        int index;
        while ((index = maxString.indexOf(minString)) != -1) {
            count++;
            maxString = maxString.substring(index + minString.length());
        }

        System.out.println(count);
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

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        System.out.println("调用方法");
        long end = System.currentTimeMillis();
        System.out.println("时间（分钟）：" + (end - start) / 60000);
    }
}
