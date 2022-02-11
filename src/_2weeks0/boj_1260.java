package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1260 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = true;
            graph[b][a] = true;
        }

        dfs(n, graph, v - 1, bw);
        bw.newLine();
        bfs(n, graph, v - 1, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int n, boolean[][] graph, int v, BufferedWriter bw) throws Exception {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.add(v);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited[current]) {
                continue;
            }

            visited[current] = true;
            bw.append(String.valueOf(current + 1)).append(' ');
            for (int next = n - 1; next >= 0; next--) {
                if (graph[current][next] && !visited[next]) {
                    stack.add(next);
                }
            }
        }
    }

    static void bfs(int n, boolean[][] graph, int v, BufferedWriter bw) throws Exception {
        boolean[] visited = new boolean[n];
        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bw.append(String.valueOf(current + 1)).append(' ');
            for (int next = 0; next < n; next++) {
                if (graph[current][next] && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
