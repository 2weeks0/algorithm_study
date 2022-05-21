package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_18119 {
    static void fun() {
        Map<Integer, List<Integer>> map = new HashMap<>();

        if (!map.containsKey(0)) {
            map.put(0, new ArrayList<>());
        }
        map.get(0).add(1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] words = new int[n];
        for (int i = 0; i < n; i++) {
            int bit = 0;
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                bit |= (1 << (word.charAt(j) - 'a'));
            }
            words[i] = bit;
        }

        int forget = 0;
        StringBuilder sb = new StringBuilder();
        int cnt = n;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            char x = st.nextToken().charAt(0);
            if (x != 'o' && x != 'u' && x != 'a' && x != 'i' && x != 'e') {
                int bit = (1 << (x - 'a'));
                if (o == 1) {
                    forget |= bit;
                } else if ((forget & bit) == bit) {
                    forget ^= (1 << (x - 'a'));
                }

                int temp = 0;
                for (int word : words) {
                    if ((word & forget) == 0) {
                        temp++;
                    }
                }

                cnt = temp;
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
