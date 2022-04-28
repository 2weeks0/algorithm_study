package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_16954 {
    static final int SIZE_BOARD = 8;
    static final int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0, 0};
    static final int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
    static boolean answer = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[SIZE_BOARD][SIZE_BOARD];
        for (int r = 0; r < SIZE_BOARD; r++) {
            String line = br.readLine();
            for (int c = 0; c < SIZE_BOARD; c++) {
                board[r][c] = line.charAt(c);
            }
        }

        recursive(board, SIZE_BOARD - 1, 0, 0);

        System.out.println(answer ? 1 : 0);
        br.close();
    }

    static void recursive(char[][] board, int r, int c, int depth) {
        if (answer) {
            return;
        } else if (r == 0 && c == SIZE_BOARD - 1) {
            answer = true;
            return;
        }

        if (0 <= r - depth && board[r - depth][c] == '#') {
            return;
        }

        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || SIZE_BOARD <= nr || nc < 0 || SIZE_BOARD <= nc || (0 <= nr - depth && board[nr - depth][nc] == '#')) {
                continue;
            }
            recursive(board, nr, nc, depth + 1);
        }
    }
}
