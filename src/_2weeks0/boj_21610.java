package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_21610 {
    static final int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    static final int[] ddr = {-1, -1, 1, 1};
    static final int[] ddc = {-1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> clouds = new ArrayList<>();
        clouds.add(parseKey(n - 1, 0));
        clouds.add(parseKey(n - 1, 1));
        clouds.add(parseKey(n - 2, 0));
        clouds.add(parseKey(n - 2, 1));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            solve(clouds, n, board, d, s);
        }

        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                answer += board[r][c];
            }
        }

        System.out.println(answer);
        br.close();
    }

    static int parseKey(int r, int c) {
        return 100 * r + c;
    }

    static void solve(List<Integer> clouds, int n, int[][] board, int d, int s) {
        Set<Integer> temp = new HashSet<>();
        for (int i = clouds.size() - 1; 0 <= i; i--) {
            int cloud = clouds.get(i);
            int r = cloud / 100;
            int c = cloud % 100;

            int nr = move(n, r + s * dr[d]);
            int nc = move(n, c + s * dc[d]);
            board[nr][nc]++;

            int nextKey = parseKey(nr, nc);
            temp.add(nextKey);
            clouds.remove(i);
        }
        for (int cloud : temp) {
            int r = cloud / 100;
            int c = cloud % 100;
            for (int j = 0; j < ddr.length; j++) {
                int tr = r + ddr[j];
                int tc = c + ddc[j];
                if (tr < 0 || n <= tr || tc < 0 || n <= tc || board[tr][tc] == 0) {
                    continue;
                }
                board[r][c]++;
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] < 2 || temp.contains(parseKey(r, c))) {
                    continue;
                }
                clouds.add(parseKey(r, c));
                board[r][c] -= 2;
            }
        }

    }

    static int move(int n, int nextPos) {
        if (nextPos < 0) {
            return (n - 1) + ((nextPos + 1) % n);
        } else {
            return nextPos % n;
        }
    }
}
