package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] subjects = new int[k + 1][2];
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            subjects[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = n; subjects[i][1] <= j ; j--) {
                dp[j] = Math.max(dp[j], dp[j - subjects[i][1]] + subjects[i][0]);
            }
        }

        System.out.println(dp[n]);
        br.close();
    }
}
