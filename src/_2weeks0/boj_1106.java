package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1106 {
    static final int MAX = 100 * 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Info[] infos = new Info[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            infos[i] = new Info(cost, num);
        }

        int[] dp = new int[MAX + 1];
        for (Info info : infos) {
            for (int i = info.cost; i <= MAX; i++) {
                dp[i] = Math.max(dp[i], dp[i - info.cost] + info.value);
            }
        }

        for (int i = 0; i <= MAX; i++) {
            if (c <= dp[i]) {
                System.out.println(i);
                break;
            }
        }

        br.close();
    }

    static class Info {
        int cost;
        int value;

        public Info(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }
    }
}
