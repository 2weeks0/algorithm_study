package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1261 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                map[r][c] = line.charAt(c) - '0';
            }
        }


        System.out.println(bfs(n, m, map));
        br.close();
    }

    static int bfs(int n, int m, int[][] map) {
        int[][] visited = new int[n][m];
        visited[0][0] = 1;

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> visited[p.r][p.c]));
        pq.add(new Point(0, 0));

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            if (current.r == n - 1 && current.c == m - 1) {
                return visited[n - 1][m - 1] - 1;
            }
            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc || visited[nr][nc] != 0) {
                    continue;
                }

                visited[nr][nc] = visited[current.r][current.c] + map[nr][nc];
                pq.add(new Point(nr, nc));
            }
        }
        return -1;
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
