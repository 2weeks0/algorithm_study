package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17182 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    graph[r][c] = Math.min(graph[r][c], graph[r][i] + graph[i][c]);
                }
            }
        }

        boolean[] visited = new boolean[n];
        visited[k] = true;
        recursive(n, graph, visited, k, 0, 1);
        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int[][] graph, boolean[] visited, int current, int dist, int depth) {
        if (depth == n) {
            answer = Math.min(answer, dist);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            recursive(n, graph, visited, i, dist + graph[current][i], depth + 1);
            visited[i] = false;
        }
    }
}
