package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        recursive(n, s, nums, 0, 0);

        System.out.println(s == 0 ? --answer : answer);
        br.close();
    }

    static void recursive(int n, int s, int[] nums, int idx, int sum) {
        if (idx == n) {
            if (s == sum) {
                answer++;
            }
            return;
        }

        recursive(n, s, nums,idx + 1, sum + nums[idx]);
        recursive(n, s, nums,idx + 1, sum);
    }
}
