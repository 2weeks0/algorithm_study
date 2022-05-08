package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3495 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[][] board = new char[h][w];
        for (int r = 0; r < h; r++) {
            String line = br.readLine();
            for (int c = 0; c < w; c++) {
                board[r][c] = line.charAt(c);
            }
        }

        int answer = 0;
        boolean flag = false;
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                char ch = board[r][c];
                if (ch == '/' || ch == '\\') {
                    flag = !flag;
                    answer += 5;
                } else if (flag) {
                    answer += 10;
                }
            }
        }

        System.out.println(answer / 10);
        br.close();
    }
}
