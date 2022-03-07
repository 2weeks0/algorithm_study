package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1405 {
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};
    static final int MAX_N = 14;

    static double answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double[] chances = new double[4];
        for (int i = 0; i < 4; i++) {
            chances[i] = (double) Integer.parseInt(st.nextToken()) / 100;
        }

        boolean[][] visited = new boolean[2 * MAX_N + 1][2 * MAX_N + 1];
        visited[MAX_N][MAX_N] = true;
        recursive(n, chances, visited, MAX_N, MAX_N, 0, 1);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, double[] chances, boolean[][] visited, int r, int c, int cnt, double chance) {
        if (cnt == n) {
            answer += chance;
            return;
        }

        for (int d = 0; d < 4; d++) {
            if (chances[d] == 0) {
                continue;
            }

            int nr = r + dr[d];
            int nc = c + dc[d];
            if (visited[nr][nc]) {
                continue;
            }
            visited[nr][nc] = true;
            recursive(n, chances, visited, nr, nc, cnt + 1, chance * chances[d]);
            visited[nr][nc] = false;
        }
    }
}
