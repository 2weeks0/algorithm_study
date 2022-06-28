package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16437 {
    static final char WOLF = 'W';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] lists = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new LinkedList<>();
        }
        long[] cnts = new long[n + 1];

        for (int i = 2; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if (t == WOLF) {
                a *= -1;
            }
            cnts[i] = a;
            lists[p].add(i);
        }

        recursive(lists, cnts, 1, 0);

        System.out.println(cnts[1]);
        br.close();
    }

    static void recursive(List<Integer>[] lists, long[] cnts, int current, int before) {
        for (int next : lists[current]) {
            recursive(lists, cnts, next, current);
        }

        if (before != 0 && 0 < cnts[current]) {
            cnts[before] += cnts[current];
        }
    }
}
