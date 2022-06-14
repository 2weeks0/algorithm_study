package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_16724 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 1);
        map.put('L', 2);
        map.put('R', 3);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                board[r][c] = map.get(line.charAt(c));
            }
        }

        int answer = 0;
        boolean[][] visited = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (!visited[r][c]) {
                    answer++;
                    recursive(n, m, board, visited, r, c);
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int m, int[][] board, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || n <= nr || nc < 0 || m <= nc || visited[nr][nc]) {
                continue;
            }

            if (d == board[r][c]) {
                recursive(n, m, board, visited, nr, nc);
            } else if (r == nr + dr[board[nr][nc]] && c == nc + dc[board[nr][nc]]) {
                recursive(n, m, board, visited, nr, nc);
            }
        }
    }
}
