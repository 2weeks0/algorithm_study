package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_22115 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[k + 1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (k < arr[i]) {
                continue;
            }
            for (int j = k - arr[i]; 0 <= j; j--) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[j + arr[i]] = Math.min(dp[j + arr[i]], dp[j] + 1);
                }
            }
            dp[arr[i]] = 1;
        }
        int answer;
        if (dp[k] == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer = dp[k];
        }

        System.out.println(answer);
        br.close();
    }
}
