package test;

import java.util.Scanner;

public class Test1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n = sc.nextInt();
        String[] s3s = new String[n];
        for(int i=0;i<n;i++){
            s3s[i]=sc.next();
        }

        judge(s1, s2, s3s);
    }

    public static void judge(String s1, String s2, String[] s3s) {
        boolean[] goodChars = new boolean[26];
        for (int i = 0; i < s1.length(); i++) {
            goodChars[s1.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < s3s.length; i++) {
            String s3 = s3s[i];
            int s3Idx = 0;
            boolean flag = true;

            for (int j = 0; j < s2.length(); j++) {
                if (s3.length() > s3Idx && s2.charAt(j) == s3.charAt(s3Idx) ||
                        s2.charAt(j) == '?' && goodChars[s3.charAt(s3Idx) - 'a']) {
                    s3Idx++;
                    continue;
                } else if (s2.charAt(j) == '*') {
                    int len = s3.length() - s2.length();
                    if (len < -1) {
                        flag = false;
                        break;
                    } else {
                        for (int k = 0; k < len + 1; k++) {
                            if (!goodChars[s3.charAt(s3Idx) - 'a']) {
                                s3Idx++;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }
                } else {
                    flag = false;
                }

                if (!flag) {
                    break;
                }
            }

            if (s3Idx == s3.length() && flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
