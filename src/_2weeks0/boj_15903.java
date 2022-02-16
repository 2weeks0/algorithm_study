package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_15903 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            assert !pq.isEmpty();
            long x = pq.poll();
            assert !pq.isEmpty();
            long y = pq.poll();

            pq.add(x + y);
            pq.add(x + y);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
        br.close();
    }
}
