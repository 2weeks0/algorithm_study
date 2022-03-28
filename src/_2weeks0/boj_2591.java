package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2591 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] dp = new int[input.length() + 1];

        dp[1] = 1;

        int temp = Integer.parseInt(input.substring(0, 2));
        if (temp % 10 != 0) {
            dp[2] += 1;
        }
        if (temp <= 34) {
            dp[2] += 1;
        }
        for (int i = 3; i <= input.length() ; i++) {
            temp = Integer.parseInt(input.substring(i - 2, i));
            if (temp % 10 != 0) {
                dp[i] += dp[i - 1];
            }
            if (10 <= temp && temp <= 34) {
                dp[i] += dp[i - 2];
            }
        }

        System.out.println(dp[input.length()]);
        br.close();
    }
}
