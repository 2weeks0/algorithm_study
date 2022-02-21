package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_6087 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    static final char BLOCKED = '*';
    static final char LASER = 'C';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] lasers = new int[2][];
        char[][] map = new char[h][];
        for (int r = 0; r < h; r++) {
            map[r] = br.readLine().toCharArray();
            for (int c = 0; c < w; c++) {
                if (map[r][c] == LASER) {
                    if (lasers[0] == null) {
                        lasers[0] = new int[]{r, c};
                    } else {
                        lasers[1] = new int[]{r, c};
                    }
                }
            }
        }

        int[][] cnt = new int[h][w];
        for (int r = 0; r < h; r++) {
            Arrays.fill(cnt[r], Integer.MAX_VALUE);
        }
        bfs(map, cnt, w, h, lasers);
        System.out.println(cnt[lasers[1][0]][lasers[1][1]]);

        br.close();
    }

    static void bfs(char[][] map, int[][] cnt, int w, int h, int[][] lasers) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{lasers[0][0], lasers[0][1], 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            System.out.println(Arrays.toString(current));
            if (current[0] == lasers[1][0] && current[1] == lasers[1][1]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int d = i % 4;
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];
                if (0 <= nr && nr < h && 0 <= nc && nc < w && map[nr][nc] != BLOCKED) {
                    if (current[0] == lasers[0][0] && current[1] == lasers[0][1]) {
                        cnt[nr][nc] = 0;
                    } else if (d == current[2]) {
                        if (cnt[nr][nc] <= cnt[current[0]][current[1]]) {
                            continue;
                        }
                        cnt[nr][nc] = cnt[current[0]][current[1]];
                    } else {
                        if (cnt[nr][nc] <= cnt[current[0]][current[1]] + 1) {
                            continue;
                        }
                        cnt[nr][nc] = cnt[current[0]][current[1]] + 1;
                    }
                    queue.add(new int[]{nr, nc, d});
                }
            }
        }
    }
}
