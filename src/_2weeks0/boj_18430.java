package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18430 {

    static int[][][] d = {
            {{0, 0}, {0, -1}, {1, 0}},
            {{0, 0}, {0, -1}, {-1, 0}},
            {{0, 0}, {0, 1}, {-1, 0}},
            {{0, 0}, {0, 1}, {1, 0}},
    };
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(n, m, board, new boolean[n][m], 0, 0);
        System.out.println(answer);

        br.close();
    }

    static void recursive(int n, int m, int[][] board, boolean[][] visited, int depth, int sum) {
        if (depth == n * m) {
            return;
        }

        int r = depth / n;
        int c = depth % m;
        outer: for (int[][] arr2 : d) {
            for (int[] arr : arr2) {
                int nr = r + arr[0];
                int nc = c + arr[1];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc || visited[nr][nc]) {
                    continue outer;
                }
            }

            int newSum = sum;
            for (int i = 0; i < arr2.length; i++) {
                int nr = r + arr2[i][0];
                int nc = c + arr2[i][1];
                visited[nr][nc] = true;
                newSum += i == 0 ? 2 * board[nr][nc] : board[nr][nc];
            }

            answer = Math.max(answer, newSum);
            recursive(n, m, board, visited, depth + 1, newSum);

            for (int[] arr : arr2) {
                int nr = r + arr[0];
                int nc = c + arr[1];
                visited[nr][nc] = false;
            }
        }
        recursive(n, m, board, visited, depth + 1, sum);
    }
}

