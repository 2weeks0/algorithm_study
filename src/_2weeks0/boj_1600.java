package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1600 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, -1, 0, 1};
    static final int[] sdr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static final int[] sdc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];

        for (int r = 0; r < h; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < w; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(w, h, k, map));

        br.close();
    }

    static int bfs(int w, int h, int k, int[][] map) {
        Queue<Point> queue = new ArrayDeque<>();
        Point start = new Point(0, 0, k);
        queue.add(start);

        int[][][] visited = new int[k + 1][h][w];
        visited[k][0][0] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.r == h - 1 && current.c == w - 1) {
                return visited[current.k][current.r][current.c] - 1;
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (isInRange(w, h, nr, nc) && map[nr][nc] == 0 && visited[current.k][nr][nc] == 0) {
                    visited[current.k][nr][nc] = visited[current.k][current.r][current.c] + 1;
                    queue.add(new Point(nr, nc, current.k));
                }
            }
            if (current.k == 0) {
                continue;
            }

            for (int d = 0; d < sdr.length; d++) {
                int nr = current.r + sdr[d];
                int nc = current.c + sdc[d];
                if (isInRange(w, h, nr, nc) && map[nr][nc] == 0 && visited[current.k - 1][nr][nc] == 0) {
                    visited[current.k - 1][nr][nc] = visited[current.k][current.r][current.c] + 1;
                    queue.add(new Point(nr, nc, current.k - 1));
                }
            }
        }

        return -1;
    }

    static boolean isInRange(int w, int h, int nr, int nc) {
        return 0 <= nr && nr < h && 0 <= nc && nc < w;
    }

    static class Point {
        int r;
        int c;
        int k;

        public Point(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
}
