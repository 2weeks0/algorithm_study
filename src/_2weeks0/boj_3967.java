package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_3967 {
    static final int R = 5;
    static final int C = 9;
    static final int[][][] d = {
            {{1, 1}, {1, 3}, {1, 5}, {1, 7}},
            {{3, 1}, {3, 3}, {3, 5}, {3, 7}},
            {{0, 4}, {1, 3}, {2, 2}, {3, 1}},
            {{0, 4}, {1, 5}, {2, 6}, {3, 7}},
            {{4, 4}, {3, 3}, {2, 2}, {1, 1}},
            {{4, 4}, {3, 5}, {2, 6}, {1, 7}},
    };
    static final int SUM = 26;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[R][C];
        boolean[] used = new boolean['L' - 'A' + 1];
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                char ch = line.charAt(c);
                board[r][c] = ch;
                if (ch != 'x' && ch != '.') {
                    used[ch - 'A'] = true;
                }
            }
        }

        recursive(board, used, 0);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(board[r][c]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }

    static boolean recursive(char[][] board, boolean[] used, int idx) {
        if (idx == R * C) {
            return true;
        }

        int r = idx / C;
        int c = idx % C;
        if (board[r][c] != 'x') {
            return recursive(board, used, idx + 1);
        }
        for (int i = 0; i <= 'L' - 'A'; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            board[r][c] = (char) ('A' + i);
            if (possible(board)) {
                if (recursive(board, used, idx + 1)) {
                    return true;
                }
            }
            board[r][c] = 'x';
            used[i] = false;
        }
        return false;
    }

    static boolean possible(char[][] board) {
        outer: for (int[][] arr2 : d) {
            int sum = 0;
            for (int[] arr : arr2) {
                if (board[arr[0]][arr[1]] == 'x') {
                    continue outer;
                }
                sum += board[arr[0]][arr[1]] - 'A' + 1;
            }
            if (sum != SUM) {
                return false;
            }
        }
        return true;
    }
}
