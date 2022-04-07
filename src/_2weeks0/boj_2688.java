package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_2688 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());


        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (j <= k) {
                        dp[i][k] += dp[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(Arrays.stream(dp[n]).sum())).append('\n');
        }
        bw.close();
        br.close();
    }
}
