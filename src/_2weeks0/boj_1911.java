package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1911 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Hole[] holes = new Hole[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            holes[i] = new Hole(x1, x2);
        }
        Arrays.sort(holes);

        int answer = 0;
        int last = -1;
        for (int i = 0; i < n; i++) {
            Hole hole = holes[i];
            if (last < hole.x1) {
                last = hole.x1;
            }
            int cnt = (int) Math.ceil((double) (hole.x2 - last) / l);
            if (cnt <= 0) {
                continue;
            }
            answer += cnt;
            last += cnt * l;
        }

        System.out.println(answer);
        br.close();
    }

    static class Hole implements Comparable<Hole> {
        int x1;
        int x2;

        public Hole(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        @Override
        public int compareTo(Hole o) {
            if (x1 == o.x1) {
                return Integer.compare(x2, o.x2);
            }
            return Integer.compare(x1, o.x1);
        }
    }
}
