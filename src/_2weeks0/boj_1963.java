package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1963 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            answer = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            bfs(before,after);

            bw.append(String.valueOf(answer)).append('\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int before, int after) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(before);
        int[] visited = new int[9000];
        visited[before - 1000] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == after) {
                answer = visited[current - 1000] - 1;
                return;
            }
            for (int i = 1; i <= 1000; i *= 10) {
                int temp = current - (current / i % 10) * i;
                for (int n = 0; n < 10; n++) {
                    int next = temp + n * i;
                    if (!isPossible(next) || visited[next - 1000] != 0) {
                        continue;
                    }
                    visited[next - 1000] = visited[current - 1000] + 1;
                    queue.add(next);
                }
            }
        }
    }

    static boolean isPossible(int temp) {
        if (temp < 1000) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(temp); i++) {
            if (temp % i == 0) {
                return false;
            }
        }
        return true;
    }
}
