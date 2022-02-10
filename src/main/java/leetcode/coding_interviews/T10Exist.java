package leetcode.coding_interviews;

import org.junit.Test;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * <p>
 * 12-28
 * <p>
 * 一开始没想到用算法，以为就普通的思维，主要是觉得首字母只出现一次，直到后来碰到个
 * 有很多首字母的测试用例，才发现没那么简单。
 *
 * @author wangbo
 * @since 2021/12/21 9:09
 */
public class T10Exist {

    @Test
    public void test() {
        // char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        // String word = "ABCCED";
        // char[][] board = {{'a'}};
        // String word = "ab";
        // char[][] board = {{'a'}};
        // String word = "b";
        // char[][] board = {{'a', 'b'}};
        // String word = "ba";
        // char[][] board = {{'a', 'a'}};
        // String word = "aaa";
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        System.out.println(exist(board, word));
    }

    /**
     * 我的解答
     */
    /*boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char cur = word.charAt(0);
        int i = 0, j = 0;
        boolean curExist = false;
        if (visited == null) {
            visited = new boolean[board.length][board[0].length];
        }
        while (i < board.length) {
            while (j < board[i].length) {
                if (board[i][j] == cur && !visited[i][j]) {
                    curExist = true;
                    visited[i][j] = true;
                    break;
                }
                j++;
            }
            if (curExist) {
                break;
            }
            j = 0;
            i++;
        }

        if (curExist) {
            if (word.length() == 1) {
                return true;
            }

            int charAt = 1;

            while (charAt < word.length()) {
                cur = word.charAt(charAt++);
                if (j - 1 >= 0 && board[i][j - 1] == cur && !visited[i][j - 1]) {
                    j--;
                    visited[i][j] = true;
                    continue;
                }
                if (j + 1 < board[i].length && board[i][j + 1] == cur && !visited[i][j + 1]) {
                    j++;
                    visited[i][j] = true;
                    continue;
                }
                if (i - 1 >= 0 && board[i - 1][j] == cur && !visited[i - 1][j]) {
                    i--;
                    visited[i][j] = true;
                    continue;
                }
                if (i + 1 < board.length && board[i + 1][j] == cur && !visited[i + 1][j]) {
                    i++;
                    visited[i][j] = true;
                    continue;
                }

                return exist(board, word);
            }

            if (charAt == word.length()) {
                return true;
            }
        }

        return false;
    }*/

    /**
     * 12-28
     * <p>
     * 官方解答
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
                // 一开始以为这样写，结果IDEA说不对——j++改变的值没有使用
                // return dfs(board, words, i, j, 0);
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i, j - 1, k + 1)
                || dfs(board, word, i, j + 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
