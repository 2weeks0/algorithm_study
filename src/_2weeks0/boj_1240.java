package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1240 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph[a][b] = weight;
            graph[b][a] = weight;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int answer;
            if (graph[a][b] != 0) {
                answer = graph[a][b];
            } else {
                int[] visited = new int[n];
                dfs(n, graph, visited, a, 1);
                answer = visited[b] - 1;
            }
            bw.append(String.valueOf(answer)).append('\n');
        }

        bw.close();
        br.close();
    }

    static void dfs(int n, int[][] graph, int[] visited, int current, int distance) {
        visited[current] = distance;
        for (int i = 0; i < n; i++) {
            if (graph[current][i] != 0 && visited[i] == 0) {
                dfs(n, graph, visited, i, distance + graph[current][i]);
            }
        }
    }
}
