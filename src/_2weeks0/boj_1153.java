package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1153 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = 2; j * i <= n; j++) {
                isPrime[i * j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            sb.append(2).append(" ").append(2).append(" ");
            parseNumber(n - 4, isPrime, sb);
        } else {
            sb.append(2).append(" ").append(3).append(" ");
            parseNumber(n - 5, isPrime, sb);
        }

        if (sb.toString().split(" ").length != 4) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
        br.close();
    }

    static void parseNumber(int num, boolean[] isPrime, StringBuilder sb) {
        for (int i = 2; i < num; i++) {
            if (isPrime[i] && isPrime[num - i]) {
                sb.append(i).append(" ").append(num - i);
                break;
            }
        }
    }
}
