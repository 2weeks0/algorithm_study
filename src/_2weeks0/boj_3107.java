package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_3107 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine() + ":X";
        String[] split = input.split(":");

        char[][] bits = new char[8][4];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(bits[i], '0');
        }


        int mid = -1;
        for (int i = 1; i < split.length - 1; i++) {
            if (split[i].isEmpty()) {
                mid = i;
                break;
            }
        }

        for (int i = 0; i < mid; i++) {
            String s = split[i];
            for (int j = 0; j < s.length(); j++) {
                bits[i][4 - s.length() + j] = s.charAt(j);
            }
        }

        for (int i = split.length - 2; mid < i; i--) {
            String s = split[i];
            for (int j = 0; j < s.length(); j++) {
                bits[7 + i - (split.length - 2)][4 - s.length() + j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] bit : bits) {
            for (char c : bit) {
                sb.append(c);
            }
            sb.append(':');
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }
}
