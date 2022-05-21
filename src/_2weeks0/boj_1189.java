package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1189 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] board = new char[r][c];
        for (int cr = 0; cr < r; cr++) {
            String line = br.readLine();
            for (int cc = 0; cc < c; cc++) {
                board[cr][cc] = line.charAt(cc);
            }
        }

        boolean[][] visited = new boolean[r][c];
        visited[r - 1][0] = true;
        dfs(r, c, k, board, visited, r - 1, 0, 0);

        System.out.println(answer);
        br.close();
    }

    static void dfs(int r, int c, int k, char[][] board, boolean[][] visited, int cr, int cc, int depth) {
        if (cr == 0 && cc == c - 1) {
            if (depth == k - 1) {
                answer++;
            }
            return;
        }

        for (int d = 0; d < dr.length; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            if (nr < 0 || r <= nr || nc < 0 || c <= nc || visited[nr][nc] || board[nr][nc] == 'T') {
                continue;
            }

            visited[cr][cc] = true;
            dfs(r, c, k, board, visited, nr, nc, depth + 1);
            visited[cr][cc] = false;
        }
    }
}
