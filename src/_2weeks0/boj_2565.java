package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2565 {
    static final int MAX = 500;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[MAX + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }

        int[] dp = new int[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            if (arr[i] == 0) {
                continue;
            }
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] != 0 && arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();

        System.out.println(n - max);
        br.close();
    }
}
