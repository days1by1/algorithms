package year2021.mine;

import java.util.*;

public class Test0107 {

    static int n;
    static int count;
    static int newCount;
    static boolean[][] isVisited;
    static Set<Point> points = new LinkedHashSet<>();
    // static List<Integer> placesX = new ArrayList<>();
    // static List<Integer> placesY = new ArrayList<>();
    static int[][] historic = new int[2][2];
    static int[][] original = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        isVisited = new boolean[n + 1][2];

        // points.add(new year2021.mine.Point(1, 1));
        // points.add(new year2021.mine.Point(1, 2));
        // points.add(new year2021.mine.Point(1, 1));
        // System.out.println(points);

        if (n >= 2) {
            for (int i = 0; i < 4; i++) {
                historic[1] = original[i];
                count = 1;
                // placesX.add(original[i][0]);
                // placesX.add(original[i][1]);
                points.add(new Point(original[i][0], original[i][1]));
                dfs();
            }
        } else {
            newCount = 4;
        }
        // historic[1][0] = 2;
        // historic[0] = historic[1];
        // historic[1][0] = 3;
        // System.out.println(historic[0][0]);

        System.out.println(newCount);

    }

    private static void dfs() {
        if (!isVisited[count + 1][0]) {
            count++;
        }
        if (count <= n) {
            int x = historic[1][0];
            int y = historic[1][1];

            if (!isVisited[count][0]) {
                if (historic[0][0] == historic[1][0] && historic[0][1] < historic[1][1]) {
                    historic[1][0] = historic[1][0] - 1;
                } else if (historic[0][1] == historic[1][1] && historic[0][0] < historic[1][0]) {
                    historic[1][1] = historic[1][1] + 1;
                } else if (historic[0][0] == historic[1][0] && historic[0][1] > historic[1][1]) {
                    historic[1][0] = historic[1][0] + 1;
                } else if (historic[0][1] == historic[1][1] && historic[0][0] > historic[1][0]) {
                    historic[1][1] = historic[1][1] - 1;
                }
                if (count == n && !points.contains(new Point(historic[1][0], historic[1][1]))) {
                    newCount++;
                }
                isVisited[count][0] = true;
                if (count < n) {
                    dfs();
                }
                isVisited[count + 1][0] = false;
            }
            if (!isVisited[count][1]) {
                if (historic[0][0] == historic[1][0] && historic[0][1] < historic[1][1]) {
                    historic[1][0] = historic[1][0] + 1;
                } else if (historic[0][1] == historic[1][1] && historic[0][0] < historic[1][0]) {
                    historic[1][0] = historic[1][0] - 1;
                } else if (historic[0][0] == historic[1][0] && historic[0][1] > historic[1][1]) {
                    historic[1][0] = historic[1][0] - 1;
                } else if (historic[0][1] == historic[1][1] && historic[0][0] > historic[1][0]) {
                    historic[1][1] = historic[1][1] + 1;
                }

                if (count == n && !points.contains(new Point(historic[1][0], historic[1][1]))) {
                    newCount++;
                }

                isVisited[count][1] = true;
                if (count < n) {
                    dfs();
                }
                isVisited[count + 1][0] = false;
            }

            // placesX.add(historic[1][0]);
            // placesY.add(historic[1][1]);
            points.add(new Point(historic[1][0], historic[1][1]));

            historic[0][0] = x;
            historic[0][1] = y;


        }


    }
}

class Point {
    int x;
    int y;

    Point() {
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "year2021.mine.Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
