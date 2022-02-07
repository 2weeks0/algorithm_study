package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1747 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (true) {
            if (isPrime(n) && isPalindrome(n)) {
                System.out.println(n);
                return;
            }
            n++;
        }
    }

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(int n) {
        String str = String.valueOf(n);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
