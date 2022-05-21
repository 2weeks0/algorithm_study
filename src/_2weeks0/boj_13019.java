package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_13019 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int[] cnts = new int[26];
        for (int i = 0; i < a.length(); i++) {
            cnts[a.charAt(i) - 'A']++;
        }

        String b = br.readLine();
        for (int i = 0; i < b.length(); i++) {
            if (--cnts[b.charAt(i) - 'A'] == -1) {
                System.out.println(-1);
                br.close();
                return;
            }
        }

        int answer = 0;
        int maxJ = a.length() - 1;
        for (int i = b.length() - 1; 0 <= i; i--) {
            for (int j = maxJ; 0 <= j; j--) {
                maxJ--;
                if (b.charAt(i) == a.charAt(j)) {
                    break;
                }
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}