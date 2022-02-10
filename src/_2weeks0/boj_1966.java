package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            int[] priority = new int[10];
            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(st.nextToken());
                priority[value]++;
                queue.add(value);
            }

            int answer = 1;
            outer: while (!queue.isEmpty()) {
                for (int i = queue.peek() + 1; i <= 9; i++) {
                    if (0 < priority[i]) {
                        queue.add(queue.poll());
                        m = m - 1 < 0 ? queue.size() - 1 : m - 1;
                        continue outer;
                    }
                }

                if (m == 0) {
                    System.out.println(answer);
                    break;
                }
                priority[queue.poll()]--;
                m = m - 1 < 0 ? queue.size() - 1 : m - 1;
                answer++;
            }
        }
    }
}
