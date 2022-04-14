package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class boj_2665 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static final int BLACK = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < n; c++) {
                board[r][c] = line.charAt(c) - '0';
            }
        }

        System.out.println(dijkstra(n, board));
        br.close();
    }

    static int dijkstra(int n, int[][] board) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));
        Set<Point> visited = new HashSet<>();
        visited.add(pq.peek());

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            if (current.r == n - 1 && current.c == n - 1) {
                return current.cntChange;
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];

                if (nr < 0 || n <= nr || nc < 0 || n <= nc) {
                    continue;
                }

                Point next;
                if (board[nr][nc] == BLACK) {
                    next = new Point(nr, nc, current.cntChange + 1);
                } else {
                    next = new Point(nr, nc, current.cntChange);
                }
                if (visited.contains(next)) {
                    continue;
                }
                visited.add(next);
                pq.add(next);
            }
        }
        return -1;
    }

    static class Point implements Comparable<Point> {
        int r;
        int c;
        int cntChange;

        public Point(int r, int c, int cntChange) {
            this.r = r;
            this.c = c;
            this.cntChange = cntChange;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (r != point.r) return false;
            if (c != point.c) return false;
            return cntChange == point.cntChange;
        }

        @Override
        public int hashCode() {
            return r + 100 * c + 10_000 * cntChange;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(cntChange, o.cntChange);
        }
    }
}
