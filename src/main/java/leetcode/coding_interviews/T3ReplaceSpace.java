package leetcode.coding_interviews;


/**
 * @author wangbo
 * @since 2021/11/30 21:11
 */
public class T3ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(replaceSpace("abc d e"));
    }

    public static String replaceSpace(String s) {
        // 方法一：JDK自带API
        // return s.replaceAll(" ", "%20");

        // 方法二：效率高于方法一
        char[] chars = new char[s.length() * 3];
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                chars[i] = '%';
                chars[i + 1] = '2';
                chars[i + 2] = '0';
                i = i + 3;
            } else {
                chars[i] = c;
                i++;
            }
        }
        return new String(chars, 0 ,i);
    }
}
