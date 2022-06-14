package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1437 {
    static final int MOD = 10_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int temp = n % 3;
        int answer;
        if (n <= 4) {
            answer = n;
        } else if (temp == 0) {
            answer = pow(3, n / 3);
        } else if (temp == 1) {
            answer = (pow(3, n / 3 - 1) * 4) % MOD;
        } else {
            answer = (pow(3, n / 3) * 2) % MOD;
        }

        System.out.println(answer);
        br.close();
    }

    static int pow(int a, int n) {
        if (n == 0) {
            return 1;
        } else if ((n & 1) == 0) {
            int temp = pow(a, n >> 1);
            return (temp * temp) % MOD;
        } else {
            int temp = pow(a, (n - 1) >> 1);
            temp = (temp * temp) % MOD;
            return (temp * a) % MOD;
        }
    }
}
