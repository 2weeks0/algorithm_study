package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2583 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    board[y][x] = 1;
                }
            }
        }

        List<Integer> sizeList = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c] || board[r][c] == 1) {
                    continue;
                }
                sizeList.add(recursive(m, n, board, visited, r, c));
            }
        }
        sizeList.sort(Integer::compare);
        System.out.println(sizeList.size());
        for (int size : sizeList) {
            System.out.printf("%d ", size);
        }
        br.close();
    }

    static int recursive(int m, int n, int[][] board, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int result = 1;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || m <= nr || nc < 0 || n <= nc || board[nr][nc] == 1 || visited[nr][nc]) {
                continue;
            }
            result += recursive(m, n, board, visited, nr, nc);
        }
        return result;
    }
}
