package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_9466 {
    static final int CIRCLE = -2;
    static final int UNVISITED = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] edges = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                edges[i] = Integer.parseInt(st.nextToken()) - 1;
            }


            int[] visited = new int[n];
            Arrays.fill(visited, UNVISITED);
            for (int i = 0; i < n; i++) {
                if (visited[i] == UNVISITED) {
                    dfs(visited, edges, i, i, i);
                }
            }

            int answer = n;
            for (int i = 0; i < n; i++) {
                if (visited[i] == CIRCLE) {
                    answer--;
                }
            }

            bw.append(String.valueOf(answer));
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    static void dfs(int[] visited, int[] edges, int current, int start, int value) {
        visited[current] = value;
        int next = edges[current];
        if (visited[next] == start) {
            value = CIRCLE;
        }

        if (visited[next] == UNVISITED || (visited[next] != CIRCLE && value == CIRCLE)) {
            dfs(visited, edges, next, start, value);
        }
    }
}
