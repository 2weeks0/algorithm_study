package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13335 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Queue<Truck> queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(new Truck(Integer.parseInt(st.nextToken())));
        }

        System.out.println(solve(queue, w, l));
        br.close();
    }

    static int solve(Queue<Truck> queue, int w, int l) {
        int cw = 0;
        int t = 0;
        Queue<Truck> onBridge = new ArrayDeque<>();
        while (!(queue.isEmpty() && onBridge.isEmpty())) {
            t++;
            int size = onBridge.size();
            for (int i = 0; i < size; i++) {
                Truck truck = onBridge.poll();
                if (++truck.x != w) {
                    onBridge.add(truck);
                } else {
                    cw -= truck.w;
                }
            }

            if (!queue.isEmpty()) {
                if (cw + queue.peek().w <= l) {
                    cw += queue.peek().w;
                    queue.peek().x++;
                    onBridge.add(queue.poll());
                }
            }

        }
        return t;
    }

    static class Truck {
        int x = -1;
        int w;

        public Truck(int w) {
            this.w = w;
        }
    }
}
