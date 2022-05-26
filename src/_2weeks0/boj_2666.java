package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2666 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] open = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        open[0] = Integer.parseInt(st.nextToken()) - 1;
        open[1] = Integer.parseInt(st.nextToken()) - 1;

        int left = Math.min(open[0], open[1]);
        int right = Math.max(open[0], open[1]);

        int m = Integer.parseInt(br.readLine());
        int[] order = new int[m];
        for (int i = 0; i < m; i++) {
            order[i] = Integer.parseInt(br.readLine()) - 1;
        }

        recursive(m, left, right, order, 0, 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int m, int left, int right, int[] order, int idx, int cnt) {
        if (answer <= cnt) {
            return;
        } else if (idx == m) {
            answer = cnt;
            return;
        }

        if (left == order[idx] || right == order[idx]) {
            recursive(m, left, right, order, idx + 1, cnt);
            return;
        }

        if (order[idx] < left) {
            recursive(m, order[idx], right, order, idx, cnt + left - order[idx]);
        } else if (right < order[idx]) {
            recursive(m, left, order[idx], order, idx, cnt + order[idx] - right);
        } else {
            recursive(m, order[idx], right, order, idx, cnt + order[idx] - left);
            recursive(m, left, order[idx], order, idx, cnt + right - order[idx]);
        }
    }
}
