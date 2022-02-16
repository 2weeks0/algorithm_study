package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class boj_18112 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        String end = br.readLine();

        bfs(stringToBinary(start), stringToBinary(end));
    }

    static void bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) {
                System.out.println(visited.get(current));
                return;
            }

            int next = current + 1;
            if (!visited.containsKey(next)) {
                queue.add(next);
                visited.put(next, visited.get(current) + 1);
            }

            if (current != 0) {
                next = current - 1;
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, visited.get(current) + 1);
                }
            }

            for (int i = 1; i <= (current >> 1); i = i << 1) {
                next = current ^ i;
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, visited.get(current) + 1);
                }
            }
        }
    }

    static int stringToBinary(String string) {
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                result += Math.pow(2, string.length() - 1 - i);
            }
        }
        return result;
    }
}
