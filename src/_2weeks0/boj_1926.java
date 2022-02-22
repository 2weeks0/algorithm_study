package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1926 {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static int cnt = 0;
    static int temp = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        int cntArea = 0;
        boolean[][] visited = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (graph[r][c] && !visited[r][c]) {
                    temp = 0;
                    cntArea++;
                    dfs(n, m, graph, visited, r, c);
                    cnt = Math.max(cnt, temp);
                }
            }
        }

        System.out.println(cntArea);
        System.out.println(cnt);
        br.close();
    }

    static void dfs(int n, int m, boolean[][] graph, boolean[][] visited, int r, int c) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{r, c});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            if (visited[current[0]][current[1]]) {
                continue;
            }
            visited[current[0]][current[1]] = true;
            temp++;
            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];
                if (0 <= nr && nr < n && 0 <= nc && nc < m && graph[nr][nc] && !visited[nr][nc]) {
                    stack.add(new int[]{nr, nc});
                }
            }
        }
    }
}
