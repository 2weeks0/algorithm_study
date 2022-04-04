package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_10830 {
    static final int MOD = 1_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] arr = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = powMat(n, arr, b);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                bw.append(String.valueOf(result[r][c])).append(' ');
            }
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    static int[][] powMat(int n, int[][] arr, long b) {
        if (b == 1) {
            return mulMat(n, arr, getE(n));
        } else if ((b & 1) == 0) {
            int[][] temp = powMat(n, arr, b >> 1);
            return mulMat(n, temp, temp);
        }
        int[][] temp = powMat(n, arr, (b - 1) >> 1);
        temp = mulMat(n, temp, temp);
        return mulMat(n, temp, arr);
    }

    static int[][] mulMat(int n, int[][] arr1, int[][] arr2) {
        int[][] result = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int temp = 0;
                for (int i = 0; i < n; i++) {
                    temp += arr1[r][i] * arr2[i][c];
                    temp %= MOD;
                }
                result[r][c] = temp;
            }
        }
        return result;
    }

    static int[][] getE(int n) {
        int[][] result = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                result[r][c] = r == c ? 1 : 0;
            }
        }
        return result;
    }
}
