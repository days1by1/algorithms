package leetcode.all;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * @author wangbo
 * @since 2021/11/24 14:40
 */
public class T3LengthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }

    // 我的解答
    public static int lengthOfLongestSubstring(String s) {
        int max = 0, i = 0, j = 0;
        if ("".equals(s)) {
            return max;
        }
        HashSet<Character> chars = new HashSet<>();
        while (j < s.length()) {
            while (j < s.length() && !chars.contains(s.charAt(j))) {
                chars.add(s.charAt(j));
                j++;
            }
            max = j - i > max ? j - i : max;
            chars.remove(s.charAt(i));
            i++;
        }
        return max;
    }

    // 官方题解
    public static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
