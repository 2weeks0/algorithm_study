package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_4179 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] board = new char[r][c];
        Queue<Point> j = new ArrayDeque<>();
        Queue<Point> f = new ArrayDeque<>();
        for (int cr = 0; cr < r; cr++) {
            String line = br.readLine();
            for (int cc = 0; cc < c; cc++) {
                board[cr][cc] = line.charAt(cc);
                if (board[cr][cc] == 'J') {
                    j.add(new Point(cr, cc));
                } else if (board[cr][cc] == 'F') {
                    f.add(new Point(cr, cc));
                }
            }
        }

        int[][] visited = new int[r][c];
        bfs(r, c, board, f, visited, false); // 불
        bfs(r, c, board, j, visited, true); // 지훈

        System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
        br.close();
    }

    static void bfs(int r, int c, char[][] board, Queue<Point> queue, int[][] visited, boolean isJ) {
        for (Point point : queue) {
            visited[point.r][point.c] = 1;
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (isJ && (current.r == 0 || current.r == r - 1 || current.c == 0 || current.c == c - 1)) {
                answer = visited[current.r][current.c];
                return;
            }
            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || r <= nr || nc < 0 || c <= nc || board[nr][nc] != '.') {
                    continue;
                }

                if (isJ && (visited[nr][nc] != 0 && visited[current.r][current.c] + 1 >= visited[nr][nc])) {
                    continue;
                } else if (!isJ && visited[nr][nc] != 0) {
                    continue;
                }

                visited[nr][nc] = visited[current.r][current.c] + 1;
                queue.add(new Point(nr, nc));
            }
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
