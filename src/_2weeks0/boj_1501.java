package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = parseKey(br.readLine());
            map.put(key , map.getOrDefault(key, 0) + 1);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            int answer = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                answer *= map.getOrDefault(parseKey(st.nextToken()), 0);
            }
            bw.append(String.valueOf(answer)).append('\n');
        }

        bw.close();
        br.close();
    }

    static int parseKey(String word) {
        PriorityQueue<Character> temp = new PriorityQueue<>();
        for (int i = 1; i <= word.length() - 1; i++) {
            temp.add(word.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        while (!temp.isEmpty()) {
            sb.append(temp.poll());
        }
        if (2 < word.length()) {
            sb.append(word.charAt(word.length() - 1));
        }
        return sb.toString().hashCode();
    }
}
