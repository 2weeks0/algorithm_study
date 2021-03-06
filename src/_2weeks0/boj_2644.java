package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2644 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            graph[x][y] = true;
            graph[y][x] = true;
        }

        bfs(graph, a, b);
    }

    static void bfs(boolean[][] graph, int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int[] visited = new int[graph.length];
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) {
                System.out.println(visited[current] - 1);
                return;
            }
            for (int to = 0; to < graph.length; to++) {
                if (graph[current][to] && visited[to] == 0) {
                    visited[to] += visited[current] + 1;
                    queue.add(to);
                }
            }
        }

        System.out.println(-1);
    }
}
