package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1783 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (2 < n) {
            if (6 < m) {
                System.out.println(m - 1 - 6 + 5);
            } else {
                System.out.println(Math.min(4, m));
            }
        } else if (1 < n) {
            System.out.println(Math.min((m - 1) / 2 + 1, 4));
        } else {
            System.out.println(1);
        }

        br.close();
    }
}
