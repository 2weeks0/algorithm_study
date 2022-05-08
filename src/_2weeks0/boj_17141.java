package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17141 {
    static final int BLOCKED = 1;
    static final int CANDIDATE = 2;
    static final int VIRUS = 3;
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Point> viruses = new ArrayList<>(m);
        int[][] board = new int[n][n];
        int cntEmpty = 0;
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if (board[r][c] != BLOCKED) {
                    cntEmpty++;
                    if (board[r][c] == CANDIDATE) {
                        viruses.add(new Point(r, c));
                    }
                }
            }
        }

        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        combination(n, m, board, visited, cntEmpty - m, viruses, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }

    static void combination(int n, int m, int[][] board, int[][] visited, int cntEmpty, List<Point> candidates, int depth, int cnt) {
        if (cnt == m) {
            int[][] tempBoard = new int[n][n];
            for (int i = 0; i < n; i++) {
                tempBoard[i] = board[i].clone();
            }
            int[][] tempVisited = new int[n][n];
            for (int i = 0; i < n; i++) {
                tempVisited[i] = visited[i].clone();
            }
            spread(n, tempBoard, tempVisited, cntEmpty,  0);
            return;
        }

        for (int i = depth; i < candidates.size(); i++) {
            Point point = candidates.get(i);
            board[point.r][point.c] = VIRUS;
            visited[point.r][point.c] = 0;
            combination(n, m, board, visited, cntEmpty, candidates, i + 1, cnt + 1);
            board[point.r][point.c] = CANDIDATE;
            visited[point.r][point.c] = -1;
        }
    }

    static void spread(int n, int[][] board, int[][] visited, int cntEmpty, int depth) {
        if (cntEmpty == 0) {
            answer = Math.min(answer, depth);
            return;
        }

        int cntAdded = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == VIRUS && visited[r][c] == depth) {
                    for (int d = 0; d < dr.length; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr < 0 || n <= nr || nc < 0 || n <= nc || visited[nr][nc] != -1 || board[nr][nc] == BLOCKED) {
                            continue;
                        }
                        visited[nr][nc] = depth + 1;
                        board[nr][nc] = VIRUS;
                        cntAdded++;
                    }
                }
            }
        }
        if (cntAdded == 0) {
            return;
        }

        spread(n, board, visited, cntEmpty - cntAdded, depth + 1);
    }


    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
