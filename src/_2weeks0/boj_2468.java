package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2468 {

    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;

        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, map[r][c]);
                maxH = Math.max(maxH, map[r][c]);
            }
        }

        int answer = 1;
        for (int h = minH; h < maxH; h++) {
            boolean[][] visited = new boolean[n][n];
            int cnt = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (!visited[r][c] && h < map[r][c]) {
                        bfs(n, r, c, h, map, visited);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
        br.close();
    }

    static void bfs(int n, int r, int c, int h, int[][] map, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];
                if (0 <= nr && nr < n && 0 <= nc && nc < n && !visited[nr][nc] && h < map[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}
