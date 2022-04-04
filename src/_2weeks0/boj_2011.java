package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2011 {
    static final int MOD = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(solve(input.length(), input));
        br.close();
    }

    static int solve(int n, String input) {
        if (input.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char bc = input.charAt(i - 2);
            char c = input.charAt(i - 1);
            if (c == '0') {
                if (bc == '1' || bc == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (bc == '1' || (bc == '2' && c <= '6')) {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[n];
    }
}
