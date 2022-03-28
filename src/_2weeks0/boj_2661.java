package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2661 {
    static String answer = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        recursive(n, new StringBuilder(), 0, -1);
        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, StringBuilder stringBuilder, int depth, int before) {
        if (answer != null) {
            return;
        } else if (depth == n) {
            answer = stringBuilder.toString();
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (i == before) {
                continue;
            }
            stringBuilder.append(i);
            if (possible(stringBuilder)) {
                recursive(n, stringBuilder, depth + 1, i);
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }

    static boolean possible(StringBuilder stringBuilder) {
        for (int i = 1; i < stringBuilder.length() - 1; i++) {
            for (int j = 0; j < stringBuilder.length(); j++) {
                if (j + 2 * i <= stringBuilder.length()) {
                    String left = stringBuilder.substring(j, j + i);
                    String right = stringBuilder.substring(j + i, j + 2 * i);
                    if (left.equals(right)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}