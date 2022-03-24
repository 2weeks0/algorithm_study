package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_10836 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][m];
        int[] info = new int[2 * m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info[a]++;
            info[a + b]++;
        }
        grow(m, board, info);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < m; c++) {
                bw.append(String.valueOf(board[r][c] + 1)).append(' ');
            }
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    static void grow(int m, int[][] board, int[] info) {
        int d = 0;
        for (int j = -(m - 1); j < m; j++) {
            d += info[j + (m - 1)];
            if (j <= 0) {
                board[-j][0] += d;
             } else {
                board[0][j] += d;
            }
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < m; c++) {
                board[r][c] = board[0][c];
            }
        }
    }
}
