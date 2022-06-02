package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11578 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] teammates = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                teammates[i] |= (1 << (Integer.parseInt(st.nextToken()) - 1));
            }
        }

        recursive(n, m, teammates, new boolean[m], 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }

    static void recursive(int n, int m, int[] teammates, boolean[] mates, int problems, int cnt) {
        if (answer <= cnt) {
            return;
        } else if (problems == (1 << n) - 1) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < m; i++) {
            if (mates[i]) {
                continue;
            }
            mates[i] = true;
            recursive(n, m, teammates, mates, problems | teammates[i], cnt + 1);
            mates[i] = false;
        }
    }
}
