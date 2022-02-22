package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_3187 {
    static final char BLOCKED = '#';
    static final char WOLF = 'v';
    static final char SHEEP = 'k';

    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    static int answerWolf = 0;
    static int answerSheep = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] graph = new char[r][];
        for (int cr = 0; cr < r; cr++) {
            graph[cr] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[r][c];
        for (int cr = 0; cr < r; cr++) {
            for (int cc = 0; cc < c; cc++) {
                if (!visited[cr][cc] && graph[cr][cc] != BLOCKED) {
                    dfs(r, c, graph, visited, cr, cc);
                }
            }
        }

        System.out.println(String.valueOf(answerSheep) + ' ' + answerWolf);
        br.close();
    }

    static void dfs(int r, int c, char[][] graph, boolean[][] visited, int cr, int cc) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(cr, cc));
        visited[cr][cc] = true;

        int cntSheep = 0;
        int cntWolf = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (0 <= nr && nr < r && 0 <= nc && nc < c && graph[nr][nc] != BLOCKED && !visited[nr][nc]) {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    if (graph[nr][nc] == SHEEP) {
                        cntSheep++;
                    } else if (graph[nr][nc] == WOLF) {
                        cntWolf++;
                    }
                }
            }
        }

        if (cntWolf < cntSheep) {
            answerSheep += cntSheep;
        } else {
            answerWolf += cntWolf;
        }
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
