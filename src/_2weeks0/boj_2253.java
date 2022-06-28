package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] small = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            small[Integer.parseInt(br.readLine())] = true;
        }

        int[][] dp = new int[n + 1][(int) Math.sqrt(2 * n) + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        if (!small[2]) {
            dp[2][1] = 1;
        }
        for (int i = 3; i <= n; i++) {
            if (small[i]) {
                continue;
            }
            for (int j = 1; 1 <= i - j  && j < dp[i].length; j++) {
                // 이전 점프에서 가속했을 경우 (+1 칸 더해서 갈 경우)
                if (dp[i - j][j - 1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - j][j - 1] + 1);
                }
                // 이전 점프랑 똑같이 갔을 경우
                if (dp[i - j][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - j][j] + 1);
                }
                // 감속할 경우
                if (j + 1 < dp[i].length && dp[i - j][j + 1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - j][j + 1] + 1);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i : dp[n]) {
            answer = Math.min(answer, i);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }
}
