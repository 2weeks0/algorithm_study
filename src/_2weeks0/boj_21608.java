package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_21608 {

    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        List<Integer>[] students = new ArrayList[n * n + 1];
        int[] order = new int[n * n];

        List<Point> pointList = new ArrayList<>(n * n);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                pointList.add(new Point(r, c));
            }
        }

        for (int i = 1; i <= n * n; i++) {
            students[i] = new ArrayList<>(4);
        }

        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            order[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                students[order[i]].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < n * n; i++) {
            sort(pointList, n, map, students, order, i);
            Point point = pointList.get(0);
            pointList.remove(0);
            map[point.r][point.c] = order[i];
        }

        System.out.println(getScore(n, map, students));
        br.close();
    }

    static void sort(List<Point> pointList, int n, int[][] map, List<Integer>[] students, int[] order, int i) {
        pointList.sort((p1, p2) -> {
            int cntFavorite1 = getCntFavorite(n, map, students, order, p1, i);
            int cntFavorite2 = getCntFavorite(n, map, students, order, p2, i);
            if (cntFavorite1 == cntFavorite2) {
                int cntEmpty1 = getCntEmpty(n, map, p1);
                int cntEmpty2 = getCntEmpty(n, map, p2);
                if (cntEmpty1 == cntEmpty2) {
                    if (p1.r == p2.r) {
                        return Integer.compare(p1.c, p2.c);
                    }
                    return Integer.compare(p1.r, p2.r);
                }
                return Integer.compare(cntEmpty2, cntEmpty1);
            }
            return Integer.compare(cntFavorite2, cntFavorite1);
        });
    }

    static int getCntFavorite(int n, int[][] map, List<Integer>[] students, int[] order, Point point, int i) {
        int result = 0;
        for (int d = 0; d < 4; d++) {
            int nr = point.r + dr[d];
            int nc = point.c + dc[d];
            if (isInRange(n, nr, nc) && students[order[i]].contains(map[nr][nc])) {
                result++;
            }
        }
        return result;
    }

    static int getCntEmpty(int n, int[][] map, Point point) {
        int result = 0;
        for (int d = 0; d < 4; d++) {
            int nr = point.r + dr[d];
            int nc = point.c + dc[d];
            if (isInRange(n, nr, nc) && map[nr][nc] == 0) {
                result++;
            }
        }
        return result;
    }

    static int getScore(int n, int[][] map, List<Integer>[] students) {
        int result = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (isInRange(n, nr, nc) && students[map[r][c]].contains(map[nr][nc])) {
                        cnt++;
                    }
                }
                if (cnt != 0) {
                    result += Math.pow(10, cnt - 1);
                }
            }
        }
        return result;
    }

    static boolean isInRange(int n, int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
