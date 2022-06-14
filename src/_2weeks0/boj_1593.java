package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1593 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String w = br.readLine();
        String s = br.readLine();
        int[] cnts = new int[52];
        for (int i = 0; i < w.length(); i++) {
            cnts[getKey(w.charAt(i))]++;
        }

        int answer = 0;
        Deque<Character> deque = new ArrayDeque<>(w.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (0 < cnts[getKey(ch)]) {
                cnts[getKey(ch)]--;
                deque.addLast(ch);
                if (deque.size() == w.length()) {
                    answer++;
                    assert !deque.isEmpty();
                    cnts[getKey(deque.pollFirst())]++;
                }
                continue;
            }

            if (!deque.isEmpty()) {
                cnts[getKey(deque.pollFirst())]++;
                i--;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static int getKey(char ch) {
        if ('a' <= ch && ch <= 'z') {
            return ch - 'a';
        } else {
            return ch - 'A' + 26;
        }
    }
}
