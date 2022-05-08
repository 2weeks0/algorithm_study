package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10164 {
    static final int[] dr = {0, 1};
    static final int[] dc = {1, 0};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        recursive(n, m, k / m, k % m, 0, 0, k == -1);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int m, int kr, int kc, int r, int c, boolean pass) {
        if (!pass && (kr < r || kc < c)) {
            return;
        } else if (r == n - 1 && c == m - 1) {
            answer++;
            return;
        }

        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (n <= nr || m <= nc) {
                continue;
            }
            recursive(n, m, kr, kc, nr, nc, (pass | (nr == kr && nc == kc)));
        }
    }
}
