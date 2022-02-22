package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2589 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    static int maxDistance = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] map = new char[h][];
        for (int r = 0; r < h; r++) {
            map[r] = br.readLine().toCharArray();
        }

        int[][] visited = new int[h][w];
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (map[r][c] == 'L') {
                    for (int i = 0; i < h; i++) {
                        Arrays.fill(visited[i], 0);
                    }
                    bfs(w, h, map, visited, r, c);
                }
            }
        }

        System.out.println(maxDistance - 1);
        br.close();
    }

    static void bfs(int w, int h, char[][] map, int[][] visited, int sr, int sc) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(sr, sc));
        visited[sr][sc] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            maxDistance = Math.max(maxDistance, visited[current.r][current.c]);

            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (0 <= nr && nr < h && 0 <= nc && nc < w && map[nr][nc] == 'L' && visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[current.r][current.c] + 1;
                    queue.add(new Point(nr, nc));
                }
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
