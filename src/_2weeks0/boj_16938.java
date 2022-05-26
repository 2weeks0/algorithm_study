package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16938 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursive(n, l, r, x, arr, new boolean[n], 0,0, Integer.MAX_VALUE, 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int l, int r, int x, int[] arr, boolean[] selected, int idx, int sum, int easiest, int hardest) {
        if (r < sum) {
            return;
        } else if (l <= sum && x <= hardest - easiest) {
            answer++;
        }

        for (int i = idx; i < n; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            recursive(n, l, r, x, arr, selected, i + 1, sum + arr[i], Math.min(easiest, arr[i]), Math.max(hardest, arr[i]));
            selected[i] = false;
        }
    }
}
