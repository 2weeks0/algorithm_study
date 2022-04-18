package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_2234 {
    static final int[] dr = {0, -1, 0, 1};
    static final int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[m][n];
        for (int r = 0; r < m; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Map<Integer, Integer> roomSizeMap = new HashMap<>();
        int type = 0;
        int[][] visited = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c] == 0) {
                    int size = recursive(m, n, board, visited, ++type, r, c);
                    roomSizeMap.put(type, size);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n - 1; c++) {
                if ((board[r][c] & (1 << 2)) != 0 && visited[r][c] != visited[r][c + 1]) {
                    max = Math.max(max, roomSizeMap.get(visited[r][c]) + roomSizeMap.get(visited[r][c + 1]));
                }
            }
        }

        for (int c = 0; c < n; c++) {
            for (int r = 0; r < m - 1; r++) {
                if ((board[r][c] & (1 << 3)) != 0 && visited[r][c] != visited[r + 1][c]) {
                    max = Math.max(max, roomSizeMap.get(visited[r][c]) + roomSizeMap.get(visited[r + 1][c]));
                }
            }
        }

        System.out.println(roomSizeMap.size());
        System.out.println(roomSizeMap.values().stream().max(Integer::compare).get());
        System.out.println(max);
        br.close();
    }

    static int recursive(int m, int n, int[][] board, int[][] visited, int type, int r, int c) {
        if (visited[r][c] != 0) {
            return 0;
        }
        visited[r][c] = type;
        int result = 1;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || m <= nr || nc < 0 || n <= nc || (board[r][c] & (1 << d)) != 0) {
                continue;
            }
            result += recursive(m, n, board, visited, type, nr, nc);
        }
        return result;
    }
}
