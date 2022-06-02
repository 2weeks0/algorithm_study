package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum = 0;
        int[] cnt = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken()) % m;
            sum %= m;
            cnt[sum]++;
        }

        long answer = 0;
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                answer += cnt[i];
            }
            answer += (long) cnt[i] * (cnt[i] - 1) / 2;
        }

        System.out.println(answer);
        br.close();
    }
}
