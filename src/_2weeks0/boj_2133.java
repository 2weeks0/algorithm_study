package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2133 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        if ((n & 1) == 0) {
            int[] dp = new int[(n >> 1) + 1];
            dp[1] = 3;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[1] * dp[i - 1];
                for (int j = i - 2; 0 < j; j--) {
                    dp[i] += 2 * dp[j];
                }
                dp[i] += 2;
            }
            answer = dp[n >> 1];
        }
        System.out.println(answer);
        br.close();
    }
}
