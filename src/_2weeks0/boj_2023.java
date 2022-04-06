package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2023 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        recursive(n, 2, bw);
        recursive(n, 3, bw);
        recursive(n, 5, bw);
        recursive(n, 7, bw);

        bw.close();
        br.close();
    }

    static void recursive(int n, int value, BufferedWriter bw) throws Exception {
        String str = String.valueOf(value);
        if (str.length() == n) {
            bw.append(str);
            bw.newLine();
            return;
        }

        for (int i = 0; i < 10; i++) {
            int nValue = value * 10 + i;
            if (isPrime(nValue)) {
                recursive(n, nValue, bw);
            }
        }
    }

    static boolean isPrime(int value) {
        if (value == 2) {
            return true;
        }

        int temp = (int) Math.sqrt(value);
        for (int i = 2; i <= temp; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
