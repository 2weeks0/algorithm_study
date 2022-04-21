package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class boj_14226 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        System.out.println(bfs(s));
        br.close();
    }

    static int bfs(int s) {
        Queue<Status> queue = new ArrayDeque<>();
        queue.add(new Status(1, 0));
        Map<Status, Integer> visited = new HashMap<>();
        visited.put(queue.peek(), 0);

        while (!queue.isEmpty()) {
            Status current = queue.poll();
            if (current.view == s) {
                return visited.get(current);
            }

            for (int i = 0; i < 3; i++) {
                Status next;
                switch (i) {
                    case 0:
                        next = new Status(current.view, current.view);
                        break;
                    case 1:
                        next = new Status(current.view + current.clip, current.clip);
                        break;
                    default:
                    case 2:
                        next = new Status(current.view - 1, current.clip);
                        break;
                }
                if (!visited.containsKey(next)) {
                    visited.put(next, visited.get(current) + 1);
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    static class Status {
        int view;
        int clip;

        public Status(int view, int clip) {
            this.view = view;
            this.clip = clip;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Status)) {
                return false;
            }
            return view == ((Status) o).view && clip == ((Status) o).clip;
        }

        @Override
        public int hashCode() {
            return view * 10_000 + clip;
        }
    }
}
