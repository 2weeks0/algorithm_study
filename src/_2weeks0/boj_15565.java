package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15565 {
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

        int left = 0;
        int right = 0;
        int cnt = arr[0] == 1 ? 1 : 0;
        int answer = Integer.MAX_VALUE;

        while (true) {
            if (cnt < k) {
                right++;
                if (right == n) {
                    break;
                }
                cnt += arr[right] == 1 ? 1 : 0;
            } else if (cnt == k) {
                answer = Math.min(answer, right - left + 1);
                cnt -= arr[left] == 1 ? 1 : 0;
                left++;
                if (left == right) {
                    break;
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }
}
