package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_12026 {
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String blocks = br.readLine();

        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            char current = blocks.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char next = blocks.charAt(j);
                if (current == 'B' && next == 'O' || current == 'O' && next == 'J' || current == 'J' && next == 'B') {
                    dp[j] = Math.min(dp[j], (int) Math.pow((j - i), 2) + dp[i]);
                }
            }
        }

        System.out.println(dp[n - 1] == INF ? -1 : dp[n - 1]);
        br.close();
    }
}
