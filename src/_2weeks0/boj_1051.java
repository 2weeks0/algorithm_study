package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1051 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                map[r][c] = line.charAt(c) - '0';
            }
        }

        for (int d = Math.min(n - 1, m - 1); d >= 0; d--) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (r + d < n && c + d < m
                            && map[r][c] == map[r + d][c]
                            && map[r + d][c] == map[r + d][c + d]
                            && map[r + d][c + d] == map[r][c + d]) {
                        System.out.println((int) Math.pow(d + 1, 2));
                        return;
                    }
                }
            }
        }
    }
}
