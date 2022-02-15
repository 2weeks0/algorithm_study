package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj_14395 {

    static final char[] op = new char[]{'*', '+', '-', '/'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        if (s == t) {
            System.out.println(0);
            return;
        }

        bfs(s, t);

        br.close();
    }

    static void bfs(int s, int t) throws Exception {
        Queue<Long> queue = new ArrayDeque<>();
        queue.add((long) s);
        Map<Long, Data> visited = new HashMap<>();
        visited.put((long) s, null);

        while (!queue.isEmpty()) {
            long current = queue.poll();
            if (current == t) {
                printAnswer(s, t, visited);
                return;
            }
            for (int i = 0; i < 4; i++) {
                long next = -1;
                if (i == 0) {
                    next = current * current;
                } else if (i == 1) {
                    next = 2L * current;
                } else if (i == 2) {
                    next = 0;
                } else if (current != 0) {
                    next = 1;
                }
                if (0 <= next && !visited.containsKey(next)) {
                    visited.put(next, new Data(op[i], current));
                    queue.add(next);
                }
            }
        }

        System.out.println(-1);
    }

    static void printAnswer(int s, int t, Map<Long, Data> visited) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        long temp = t;
        while (temp != s && visited.containsKey(temp)) {
            Data data = visited.get(temp);
            stack.push(data.c);
            temp = data.from;
        }

        while (!stack.isEmpty()) {
            bw.append(stack.pop());
        }

        bw.flush();
        bw.close();
    }

    static class Data {
        char c;
        long from;

        public Data(char c, long from) {
            this.c = c;
            this.from = from;
        }
    }
}
