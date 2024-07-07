package leetcode.daily_question;

/**
 * @author wangbo
 * @since 2024年07月07日 14:10
 */
public class No1958_CheckMove {

    public static void main(String[] args) {

    }

    /**
     * 我的解答
     */
    public static boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        char opposite = color == 'W' ? 'B' : 'W';

        // 上
        int i = rMove - 1;
        while (i >= 0 && board[i][cMove] == opposite) {
            i--;
        }
        if (i >= 0 && rMove - i >= 2 && board[i][cMove] == color) {
            return true;
        }

        // 下
        i = rMove + 1;
        while (i < 8 && board[i][cMove] == opposite) {
            i++;
        }
        if (i < 8 && i - rMove >= 2 && board[i][cMove] == color) {
            return true;
        }

        // 左
        int j = cMove - 1;
        while (j >= 0 && board[rMove][j] == opposite) {
            j--;
        }
        if (j >= 0 && cMove - j >= 2 && board[rMove][j] == color) {
            return true;
        }

        // 右
        j = cMove + 1;
        while (j < 8 && board[rMove][j] == opposite) {
            j++;
        }
        if (j < 8 && j - cMove >= 2 && board[rMove][j] == color) {
            return true;
        }

        // 左上
        i = rMove - 1;
        j = cMove - 1;
        while (i >= 0 && j >= 0 && board[i][j] == opposite) {
            i--;
            j--;
        }
        if (i >= 0 && j >= 0 && rMove - i >= 2 && board[i][j] == color) {
            return true;
        }

        // 右上
        i = rMove - 1;
        j = cMove + 1;
        while (i >= 0 && j < 8 && board[i][j] == opposite) {
            i--;
            j++;
        }
        if (i >= 0 && j < 8 && rMove - i >= 2 && board[i][j] == color) {
            return true;
        }

        // 左下
        i = rMove + 1;
        j = cMove - 1;
        while (i < 8 && j >= 0 && board[i][j] == opposite) {
            i++;
            j--;
        }
        if (i < 8 && j >= 0 && i - rMove >= 2 && board[i][j] == color) {
            return true;
        }

        // 右下
        i = rMove + 1;
        j = cMove + 1;
        while (i < 8 && j < 8 && board[i][j] == opposite) {
            i++;
            j++;
        }
        if (i < 8 && j < 8 && i - rMove >= 2 && board[i][j] == color) {
            return true;
        }

        return false;
    }


    // 上、下、左、右、左上、右上、左下、右下共 8 个方向
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    /*
     * 灵茶山艾府题解
     * 启发：
     * 1、用数组枚举出所有移动方向
     * 2、逆向思维：需要多个条件同时成立时，若显得冗余可以取反
     */
    public static boolean checkMove2(char[][] board, int rMove, int cMove, char color) {
        int m = board.length, n = board[0].length;
        // char oppositeColor = color == 'B' ? 'W' : 'B';
        char oppositeColor = (char) (color ^ 'B' ^ 'W');

        for (int[] dir : DIRS) {
            int x = rMove + dir[0];
            int y = cMove + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != oppositeColor) {
                continue;
            }
            while (true) {
                x += dir[0];
                y += dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '.') {
                    break;
                }
                if (board[x][y] == color) {
                    return true;
                }
            }
        }

        return false;
    }

}
