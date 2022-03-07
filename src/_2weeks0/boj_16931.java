package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 2 * n * m;

        for (int r = 0; r < n; r++) {
            answer += arr[r][0];
            for (int c = 1; c < m; c++) {
                int diff = arr[r][c] - arr[r][c - 1];
                if (0 < diff) {
                    answer += diff;
                }
            }
            answer += arr[r][m - 1];
            for (int c = m - 2; 0 <= c; c--) {
                int diff = arr[r][c] - arr[r][c + 1];
                if (0 < diff) {
                    answer += diff;
                }
            }
        }

        for (int c = 0; c < m; c++) {
            answer += arr[0][c];
            for (int r = 1; r < n; r++) {
                int diff = arr[r][c] - arr[r - 1][c];
                if (0 < diff) {
                    answer += diff;
                }
            }
            answer += arr[n - 1][c];
            for (int r = n - 2; 0 <= r; r--) {
                int diff = arr[r][c] - arr[r + 1][c];
                if (0 < diff) {
                    answer += diff;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
