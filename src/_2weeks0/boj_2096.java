package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2096 {
    static final int[] dc = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp1 = new int[3];
        int[] dp2 = new int[3];
        for (int r = 0; r < n; r++) {
            int[] temp1 = dp1.clone();
            int[] temp2 = dp2.clone();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; c++) {
                int value = Integer.parseInt(st.nextToken());
                if (r == 0) {
                    dp1[c] = value;
                    dp2[c] = value;
                } else {
                    dp2[c] = Integer.MAX_VALUE;
                    for (int d : dc) {
                        int nc = c + d;
                        if (nc < 0 || 3 <= nc) {
                            continue;
                        }
                        dp1[c] = Math.max(dp1[c], temp1[nc] + value);
                        dp2[c] = Math.min(dp2[c], temp2[nc] + value);
                    }
                }
            }
        }

        System.out.printf("%d %d", Arrays.stream(dp1).max().getAsInt(), Arrays.stream(dp2).min().getAsInt());
        br.close();
    }
}
