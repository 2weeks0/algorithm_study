package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2293 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[Math.max(k + 1, Arrays.stream(coins).max().getAsInt() + 1)];
        for (int coin : coins) {
            dp[coin]++;
            for (int j = coin + 1; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[k]);
        br.close();
    }
}
