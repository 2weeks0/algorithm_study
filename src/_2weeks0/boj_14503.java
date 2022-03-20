package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503 {
    static final int DIRTY = 0;
    static final int BLOCKED = 1;
    static final int CLEAN = 2;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int cr = 0; cr < n; cr++) {
            st = new StringTokenizer(br.readLine());
            for (int cc = 0; cc < m; cc++) {
                map[cr][cc] = Integer.parseInt(st.nextToken());
            }
        }

        clean(map, new boolean[n][m], r, c, d);

        int answer = 0;
        for (int cr = 0; cr < n; cr++) {
            for (int cc = 0; cc < m; cc++) {
                if (map[cr][cc] == CLEAN) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void clean(int[][] map, boolean[][] visited, int r, int c, int d) {
        visited[r][c] = true;
        map[r][c] = CLEAN;

        int dLeft = d;
        for (int i = 0; i < 4; i++) {
            dLeft = dLeft == 0 ? 3 : dLeft - 1;
            int nr = r + dr[dLeft];
            int nc = c + dc[dLeft];
            if (map[nr][nc] == DIRTY && !visited[nr][nc]) {
                clean(map, visited, nr, nc, dLeft);
                return;
            }
        }

        int nr = r - dr[dLeft];
        int nc = c - dc[dLeft];
        if (map[nr][nc] != BLOCKED) {
            clean(map, visited, nr, nc, dLeft);
        }
    }
}
