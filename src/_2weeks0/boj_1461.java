package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int idx = n;
        for (int i = 0; i < n; i++) {
            if (0 < arr[i]) {
                idx = i;
                break;
            }
        }

        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < idx; i++) {
            cnt++;
            if (cnt == 1) {
                answer += 2 * Math.abs(arr[i]);
            }
            if (cnt == m) {
                cnt = 0;
            }
        }

        cnt = 0;
        for (int i = n - 1; idx <= i; i--) {
            cnt++;
            if (cnt == 1) {
                answer += 2 * arr[i];
            }
            if (cnt == m) {
                cnt = 0;
            }
        }

        answer -= Math.max(-arr[0], arr[n - 1]);
        System.out.println(answer);
        br.close();
    }
}
