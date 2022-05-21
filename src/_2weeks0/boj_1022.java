package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1022 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] idxes = new int[4];
        int n = 0;
        for (int i = 0; i < idxes.length; i++) {
            idxes[i] = Integer.parseInt(st.nextToken());
            n = Math.max(n, Math.abs(idxes[i]));
        }
        for (int i = 0; i < idxes.length; i++) {
            idxes[i] += n;
        }
        int r = idxes[2] - idxes[0] + 1;
        int c = idxes[3] - idxes[1] + 1;

        int[][] arr = new int[r][c];

        if (isInRange(idxes, n, n)) {
            arr[n - idxes[0]][n - idxes[1]] = 1;
        }
        for (int d = 1; d <= n; d++) {
            tornado(arr, idxes, n + d, n + d, (2 * (d - 1) + 1) * (2 * (d - 1) + 1), d);
        }


        printAnswer(arr, r, c);
        br.close();
    }

    static void tornado(int[][] arr, int[] idxes, int cr, int cc, int k, int d) {
        for (int i = 0; i < 2 * d; i++) {
            ++k;
            if (isInRange(idxes, --cr, cc)) {
                arr[cr - idxes[0]][cc - idxes[1]] = k;
            }
        }
        for (int i = 0; i < 2 * d; i++) {
            ++k;
            if (isInRange(idxes, cr, --cc)) {
                arr[cr - idxes[0]][cc - idxes[1]] = k;
            }
        }
        for (int i = 0; i < 2 * d; i++) {
            ++k;
            if (isInRange(idxes, ++cr, cc)) {
                arr[cr - idxes[0]][cc - idxes[1]] = k;
            }
        }
        for (int i = 0; i < 2 * d; i++) {
            ++k;
            if (isInRange(idxes, cr, ++cc)) {
                arr[cr - idxes[0]][cc - idxes[1]] = k;
            }
        }
    }

    static boolean isInRange(int[] idxes, int cr, int cc) {
        return idxes[0] <= cr && cr <= idxes[2] && idxes[1] <= cc && cc <= idxes[3];
    }

    static void printAnswer(int[][] arr, int r, int c) {
        StringBuilder sb = new StringBuilder();
        int maxLength = String.valueOf(Math.max(arr[0][0], arr[r - 1][c - 1])).length();
        for (int cr = 0; cr < r; cr++) {
            for (int cc = 0; cc < c; cc++) {
                int length = String.valueOf(arr[cr][cc]).length();
                for (int i = 0; i <= maxLength - length - (cc == 0 ? 1 : 0); i++) {
                    sb.append(' ');
                }
                sb.append(arr[cr][cc]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
