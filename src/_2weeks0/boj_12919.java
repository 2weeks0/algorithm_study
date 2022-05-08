package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_12919 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        System.out.println(recursive(s, t) ? 1 : 0);
        br.close();
    }

    static boolean recursive(StringBuilder s, StringBuilder t) {
        if (s.length() == t.length()) {
            return s.toString().equals(t.toString());
        }

        if (t.charAt(t.length() - 1) == 'A') {
            t.setLength(t.length() - 1);
            if (recursive(s, t)) {
                return true;
            }
            t.append('A');
        }

        if (t.charAt(0) == 'B') {
            t.reverse();
            t.setLength(t.length() - 1);
            if (recursive(s, t)) {
                return true;
            }
            t.append('B');
            t.reverse();
        }
        return false;
    }
}
