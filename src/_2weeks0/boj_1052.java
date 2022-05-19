package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        if (n <= k) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < k - 1; i++) {
            int temp = 1;
            while (temp <= n) {
                temp = temp << 1;
            }
            n -= (temp >> 1);
        }

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int temp = 1;
        while (temp < n) {
            temp = temp << 1;
        }
        System.out.println(temp - n);
    }
}
