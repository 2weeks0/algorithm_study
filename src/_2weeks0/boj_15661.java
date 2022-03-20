package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15661 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(n, arr, new boolean[n], 1);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int[][] arr, boolean[] team, int idx) {
        if (idx == n) {
            int diff = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (r == c || team[r] != team[c]) {
                        continue;
                    }
                    diff += team[r] ? arr[r][c] : -arr[r][c];
                }
            }
            answer = Math.min(answer, Math.abs(diff));
            return;
        }

        team[idx] = true;
        recursive(n, arr, team, idx + 1);
        team[idx] = false;
        recursive(n, arr, team, idx + 1);
    }
}
