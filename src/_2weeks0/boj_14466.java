package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_14466 {
    static final int UNKNOWN = 1;
    static final int USE_ROAD = 0;
    static final int NOT_USE_ROAD = -1;
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        Map<Integer, Boolean> roadMap = new HashMap<>();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            roadMap.put(parseToKey(r1, c1, r2, c2), true);
            roadMap.put(parseToKey(r2, c2, r1, c1), true);
        }

        Queue<Point> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            queue.add(new Point(i, r1, c1));
        }

        int[][][] map = new int[k][n][n];
        bfs(n, map, queue, roadMap);

        int answer = 0;
        for (int i = 0; i < k; i++) {
            outer: for (int j = i + 1; j < k; j++) {
                for (int cr = 0; cr < n; cr++) {
                    for (int cc = 0; cc < n; cc++) {
                        if (map[i][cr][cc] == UNKNOWN || map[j][cr][cc] == UNKNOWN) {
                            continue;
                        }

                        if (map[i][cr][cc] == NOT_USE_ROAD && map[j][cr][cc] == NOT_USE_ROAD) {
                            continue outer;
                        }
                    }
                }
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void bfs(int n, int[][][] map, Queue<Point> queue, Map<Integer, Boolean> roadMap) {
        for (Point point : queue) {
            map[point.id][point.r][point.c] = NOT_USE_ROAD;
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int d = 0; d < dr.length; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc || map[current.id][current.r][current.c] >= map[current.id][nr][nc]) {
                    continue;
                }

                if (map[current.id][current.r][current.c] == USE_ROAD || roadMap.containsKey(parseToKey(current.r, current.c, nr, nc))) {
                    map[current.id][nr][nc] = USE_ROAD;
                } else {
                    map[current.id][nr][nc] = NOT_USE_ROAD;
                }
                queue.add(new Point(current.id, nr, nc));
            }
        }
    }

    static int parseToKey(int r1, int c1, int r2, int c2) {
        return (int) (Math.pow(100, 3) * r1 + Math.pow(100, 2) * c1 + Math.pow(100, 1) * r2 + c2);
    }

    static class Point {
        int id;
        int r;
        int c;

        public Point(int id, int r, int c) {
            this.id = id;
            this.r = r;
            this.c = c;
        }
    }
}
