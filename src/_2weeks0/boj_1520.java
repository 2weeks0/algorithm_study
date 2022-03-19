package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1520 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];

        for (int r = 0; r < m; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1);
        }
        recursive(m, n, map, dp, 0, 0);

        System.out.println(dp[0][0] / 2);
        br.close();
    }

    static int recursive(int m, int n, int[][] map, int[][] dp, int r, int c) {
        if (r == m - 1 && c == n - 1) {
            return 2;
        } else if (dp[r][c] != 1) {
            return dp[r][c];
        }

        int value = 0;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || m <= nr || nc < 0 || n <= nc || dp[nr][nc] == 0 || map[r][c] <= map[nr][nc]) {
                continue;
            }

            value += recursive(m, n, map, dp, nr, nc);
        }
        dp[r][c] = value;
        return dp[r][c];
    }
}
