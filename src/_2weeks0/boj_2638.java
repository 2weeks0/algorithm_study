package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2638 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static final int EMPTY = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int cnt = 0;
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if (board[r][c] != EMPTY) {
                    cnt++;
                }
            }
        }

        int answer = 0;
        while (cnt != 0) {
            answer++;
            int[][] visited = new int[n][m];
            dfs(n, m, board, visited, 0, 0);

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (2 <= visited[r][c]) {
                        cnt--;
                        board[r][c] = EMPTY;
                    }
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void dfs(int n, int m, int[][] board, int[][] visited, int r, int c) {
        visited[r][c]++;
        if (board[r][c] != EMPTY) {
            return;
        }
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || n <= nr || nc < 0 || m <= nc || (board[nr][nc] == EMPTY && visited[nr][nc] != 0)) {
                continue;
            }
            dfs(n, m, board, visited, nr, nc);
        }
    }
}
