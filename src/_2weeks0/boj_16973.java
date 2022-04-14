package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16973 {
    static final int BLOCKED = 1;
    static final int EAST = 0;
    static final int SOUTH = 1;
    static final int WEST = 2;
    static final int NORTH = 3;
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int sr = Integer.parseInt(st.nextToken()) - 1;
        int sc = Integer.parseInt(st.nextToken()) - 1;
        int fr = Integer.parseInt(st.nextToken()) - 1;
        int fc = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs(n, m, board, h, w, sr, sc, fr, fc));
        br.close();
    }

    static int bfs(int n, int m, int[][] board, int h, int w, int sr, int sc, int fr, int fc) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(sr, sc));
        int[][] visited = new int[n][m];
        visited[sr][sc] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.r == fr && current.c == fc) {
                return visited[fr][fc] - 1;
            }

            for (int d = 0; d < dr.length; d++) {
                if (!possible(n, m, board, h, w, current, d)) {
                    continue;
                }
                Point next = new Point(current.r + dr[d], current.c + dc[d]);
                if (visited[next.r][next.c] != 0) {
                    continue;
                }
                queue.add(next);
                visited[next.r][next.c] = visited[current.r][current.c] + 1;
            }
        }
        return -1;
    }

    static boolean possible(int n, int m, int[][] board, int h, int w, Point current, int d) {
        switch (d) {
            case EAST:
                if (current.c + w == m) {
                    return false;
                }
                for (int r = current.r; r < current.r + h; r++) {
                    if (board[r][current.c + w] == BLOCKED) {
                        return false;
                    }
                }
                return true;

            case SOUTH:
                if (current.r + h == n) {
                    return false;
                }
                for (int c = current.c; c < current.c + w; c++) {
                    if (board[current.r + h][c] == BLOCKED) {
                        return false;
                    }
                }
                return true;

            case WEST:
                if (current.c - 1 == -1) {
                    return false;
                }
                for (int r = current.r; r < current.r + h; r++) {
                    if (board[r][current.c - 1] == BLOCKED) {
                        return false;
                    }
                }
                return true;

            default:
            case NORTH:
                if (current.r - 1 == -1) {
                    return false;
                }
                for (int c = current.c; c < current.c + w; c++) {
                    if (board[current.r - 1][c] == BLOCKED) {
                        return false;
                    }
                }
                return true;
        }
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
