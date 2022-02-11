package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class boj_10026 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    static int n;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];

        for (int r = 0; r < n; r++) {
            arr[r] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                final char value = arr[r][c];
                if (bfs(r, c, (nr, nc) -> arr[nr][nc] == value)) {
                    cnt++;
                }
            }
        }

        bw.append(String.valueOf(cnt)).append(' ');
        cnt = 0;
        for (int r = 0; r < n; r++) {
            Arrays.fill(visited[r], false);
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                final char value = arr[r][c];
                if (bfs(r, c, (nr, nc) -> (value == 'B' && arr[nr][nc] == 'B') || (value != 'B' && arr[nr][nc] != 'B'))) {
                    cnt++;
                }
            }
        }
        bw.append(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bfs(int r, int c, Function function) {
        if (visited[r][c]) {
            return false;
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int d = 0; d < dr.length; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if (0 <= nr && nr < n && 0 <= nc && nc < n && !visited[nr][nc] && function.apply(nr, nc)) {
                    visited[nr][nc] = true;
                    queue.add(new Point(nr, nc));
                }
            }
        }

        return true;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    @FunctionalInterface
    interface Function {
        boolean apply(int r, int c);
    }
}
