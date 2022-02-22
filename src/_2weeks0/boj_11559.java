package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class boj_11559 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static final int w = 6;
    static final int h = 12;
    static final char EMPTY = '.';

    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[h][];
        for (int r = 0; r < h; r++) {
            map[r] = br.readLine().toCharArray();
        }

        int answer = 0;
        while (true) {
            order(map);
            if (!pop(map)) {
                break;
            }
            answer++;
        }

        System.out.println(answer);
        br.close();
    }

    static boolean pop(char[][] map) {
        cnt = 0;
        boolean[][] visited = new boolean[h][w];
        for (int r = h - 1; 0 <= r; r--) {
            for (int c = 0; c < w; c++) {
                if (map[r][c] != EMPTY && !visited[r][c]) {
                    Set<Point> set = new HashSet<>();
                    dfs(w, h, map, visited, r, c, set);
                    if (4 <= set.size()) {
                        cnt++;
                        for (Point p : set) {
                            map[p.r][p.c] = EMPTY;
                        }
                    }
                }
            }
        }
        return cnt != 0;
    }

    static void dfs(int w, int h, char[][] map, boolean[][] visited, int r, int c, Set<Point> set) {
        visited[r][c] = true;
        set.add(new Point(r, c));
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (0 <= nr && nr < h && 0 <= nc && nc < w && map[nr][nc] == map[r][c] && !visited[nr][nc]) {
                dfs(w, h, map, visited, nr, nc, set);
            }
        }
    }

    static void order(char[][] map) {
        for (int c = 0; c < w; c++) {
            for (int r = h - 1; 0 < r; r--) {
                if (map[r][c] == EMPTY && map[r - 1][c] != EMPTY) {
                    for (int cr = r - 1; 0 <= cr; cr--) {
                        map[cr + 1][c] = map[cr][c];
                    }
                    map[0][c] = EMPTY;
                    r = h;
                }
            }
        }
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }
            return r == ((Point) obj).r && c == ((Point) obj).c;
        }
    }
}
