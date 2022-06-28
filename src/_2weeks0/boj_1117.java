package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1117 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        long answer = (long) w * h;
        if (x1 < w - f) {
            answer -= (long) (c + 1) * (y2 - y1) * (Math.min(x2, w - f) - x1);
        }
        if (x1 < f) {
            answer  -= (long) (c + 1) * (y2 - y1) * (Math.min(x2, f) - x1);
        }
        System.out.println(answer);
        br.close();
    }
}
