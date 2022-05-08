package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16964 {
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] order = new int[n];
        int[] orderIndexOf = new int[n]; // indexOf
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(st.nextToken()) - 1;
            orderIndexOf[order[i]] = i;
        }

        for (List<Integer> l : graph) {
            l.sort(Comparator.comparing(i -> orderIndexOf[i]));
        }

        System.out.println(dfs(n, graph, order, new boolean[n], 0) ? 1 : 0);

        br.close();
    }

    static boolean dfs(int n, List<Integer>[] graph, int[] order, boolean[] visited, int current) {
        if (cnt == n) {
            return true;
        } else if (order[cnt] != current) {
            return false;
        }

        cnt++;
        visited[current] = true;
        for (int next : graph[current]) {
            if (!visited[next]) {
                if (!dfs(n, graph, order, visited, next)) {
                    return false;
                }
            }
        }
        return true;
    }
}

