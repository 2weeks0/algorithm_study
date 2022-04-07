package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_14499 {
    static final int[] dr = {0, 0, -1, 1};
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Dice dice = new Dice();
        int[][] board = new int[n][m];
        for (int cr = 0; cr < n; cr++) {
            st = new StringTokenizer(br.readLine());
            for (int cc = 0; cc < m; cc++) {
                board[cr][cc] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken()) - 1;
            r += dr[d];
            c += dc[d];
            if (r < 0 || n <= r || c < 0 || m <= c) {
                r -= dr[d];
                c -= dc[d];
                continue;
            }
            int top = dice.roll(board, r, c, d);
            bw.append(String.valueOf(top)).append('\n');
        }
        bw.close();
        br.close();
    }

    static class Dice {
        static final int IDX_BOT = 0;
        static final int IDX_LEFT = 1;
        static final int IDX_FRONT = 2;
        static final int IDX_RIGHT = 3;
        static final int IDX_BACK = 4;
        static final int IDX_TOP = 5;
        int[] nums = new int[6];

        int roll(int[][] board, int r, int c, int d) {
            changeStatus(d);
            if (board[r][c] == 0) {
                board[r][c] = nums[IDX_BOT];
            } else {
                nums[IDX_BOT] = board[r][c];
                board[r][c] = 0;
            }
            return nums[IDX_TOP];
        }

        void changeStatus(int d) {
            int temp;
            switch (d) {
                case 0:
                    temp = nums[IDX_BOT];
                    nums[IDX_BOT] = nums[IDX_RIGHT];
                    nums[IDX_RIGHT] = nums[IDX_TOP];
                    nums[IDX_TOP] = nums[IDX_LEFT];
                    nums[IDX_LEFT] = temp;
                    break;
                case 1:
                    temp = nums[IDX_BOT];
                    nums[IDX_BOT] = nums[IDX_LEFT];
                    nums[IDX_LEFT] = nums[IDX_TOP];
                    nums[IDX_TOP] = nums[IDX_RIGHT];
                    nums[IDX_RIGHT] = temp;
                    break;
                case 2:
                    temp = nums[IDX_BOT];
                    nums[IDX_BOT] = nums[IDX_BACK];
                    nums[IDX_BACK] = nums[IDX_TOP];
                    nums[IDX_TOP] = nums[IDX_FRONT];
                    nums[IDX_FRONT] = temp;
                    break;
                case 3:
                    temp = nums[IDX_BOT];
                    nums[IDX_BOT] = nums[IDX_FRONT];
                    nums[IDX_FRONT] = nums[IDX_TOP];
                    nums[IDX_TOP] = nums[IDX_BACK];
                    nums[IDX_BACK] = temp;
                    break;
            }
        }
    }
}
