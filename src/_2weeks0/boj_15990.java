package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_15990 {
    static final int MAX_N = 100_000;
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] dp = new int[MAX_N + 1][4];
        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 2 1
        dp[3][2] = 1; // 1 2
        dp[3][3] = 1; // 3
        for (int i = 4; i <= MAX_N; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }


        int tc = Integer.parseInt(br.readLine());
        for (int t = 1 ; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int i = 1; i <= 3; i++) {
                answer += dp[n][i];
                answer %= MOD;
            }
            bw.append(String.valueOf(answer)).append('\n');
        }

        bw.close();
        br.close();
    }
}
