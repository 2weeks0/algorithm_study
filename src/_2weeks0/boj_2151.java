package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2151 {
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];

        int sr = -1;
        int sc = -1;
        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < n; c++) {
                char ch = line.charAt(c);
                board[r][c] = ch;
                if (sr == -1 && ch == '#') {
                    sr = r;
                    sc = c;
                    board[r][c] = '.';
                }
            }
        }

        System.out.println(bfs(n, board, sr, sc));
        br.close();
    }

    static int bfs(int n, char[][] board, int sr, int sc) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        for (int d = 0; d < dr.length; d++) {
            queue.add(new Point(sr, sc, d, 0));
        }

        boolean[][][] visited = new boolean[4][n][n];

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (board[current.r][current.c] == '#') {
                return current.cnt;
            }

            if (visited[current.d][current.r][current.c]) {
                continue;
            }
            visited[current.d][current.r][current.c] = true;

            int nr = current.r + dr[current.d];
            int nc = current.c + dc[current.d];
            if (nr < 0 || n <= nr || nc < 0 || n <= nc || board[nr][nc] == '*') {
                continue;
            }

            if (board[nr][nc] == '!') {
                queue.add(new Point(nr, nc, (current.d + 1) % 4, current.cnt + 1));
                queue.add(new Point(nr, nc, (current.d + 3) % 4, current.cnt + 1));
            }
            queue.add(new Point(nr, nc, current.d, current.cnt));
        }

        return -1;
    }

    static class Point implements Comparable<Point> {
        int r;
        int c;
        int d;
        int cnt;

        public Point(int r, int c, int d, int cnt) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }
}
