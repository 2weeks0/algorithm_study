package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_9177 {
    static boolean find = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            find = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();

            recursive(new HashSet<>(), a, b, c, -1, -1, 0);
            bw.append("Data set ").append(String.valueOf(t + 1)).append(": ")
                    .append(find ? "yes" : "no").append('\n');
        }
        bw.close();
        br.close();
    }

    static void recursive(Set<Integer> set, String a, String b, String c, int idx1, int idx2, int depth) {
        if (find) {
            return;
        } else if (depth == c.length()) {
            find = true;
            return;
        }

        if (set.contains(parseKey(idx1, idx2))) {
            return;
        }

        set.add(parseKey(idx1, idx2));

        if (idx1 + 1 < a.length() && a.charAt(idx1 + 1) == c.charAt(depth)) {
            recursive(set, a, b, c, idx1 + 1, idx2, depth + 1);
        }
        if (idx2 + 1 < b.length() && b.charAt(idx2 + 1) == c.charAt(depth)) {
            recursive(set, a, b, c, idx1, idx2 + 1, depth + 1);
        }
    }

    static int parseKey(int idx1, int idx2) {
        return idx1 + 1_000 * idx2;
    }
}
