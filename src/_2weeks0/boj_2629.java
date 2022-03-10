package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_2629 {
    static final int MAX = 50000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] dp = new boolean[n][MAX + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][Integer.parseInt(st.nextToken())] = true;

        for (int i = 1; i < n; i++) {
            int weight = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= MAX; j++) {
                for (int k = 0; k < i; k++) {
                    if (dp[k][j]) {
                        if (j + weight <= MAX) {
                            dp[i][j + weight] = true;
                        }
                        dp[i][Math.abs(j - weight)] = true;
                    }
                }
                dp[i][weight] = true;
            }
        }


        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        outer: for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < dp.length; j++) {
                if (dp[j][num]) {
                    bw.append('Y').append(' ');
                    continue outer;
                }
            }
            bw.append('N').append(' ');
        }

        bw.close();
        br.close();
    }
}
