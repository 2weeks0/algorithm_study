package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_1599 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine().replace("ng", "z");
        }
        Arrays.sort(words, (w1, w2) -> compare(w1, w2));
        for (String word : words) {
            bw.append(word.replace("z", "ng")).append('\n');
        }
        bw.close();
        br.close();
    }

    static int compare(String w1, String w2) {
        int i = 0;

        while (true) {
            if (i == w1.length()) {
                return -1;
            } else if (i == w2.length()) {
                return 1;
            }
            int p1 = getPriority(w1.charAt(i));
            int p2 = getPriority(w2.charAt(i));
            if (p1 == p2) {
                i++;
                continue;
            }
            return Integer.compare(p1, p2);
        }
    }

    static int getPriority(char c) {
        if (c == 'k') {
            return 'c';
        } else if (c == 'z') {
            return 'o';
        } else if ('n' < c) {
            return c + 1;
        }
        return c;
    }
}
