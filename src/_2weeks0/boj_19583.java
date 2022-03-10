package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_19583 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();

        int answer = 0;
        Set<String> set = new HashSet<>();
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            String time = st.nextToken();
            String id = st.nextToken();
            if (isAfter(time, q)) {
                break;
            }

            if (isAfter(s, time) || s.equals(time)) {
                set.add(id);
            } else if (isAfter(time, e) || e.equals(time)) {
                if (set.contains(id)) {
                    answer++;
                    set.remove(id);
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    // 00:00
    static boolean isAfter(String time, String other) {
        String[] sp1 = time.split(":");
        String[] sp2 = other.split(":");
        if (sp1[0].equals(sp2[0])) {
            return Integer.compare(Integer.parseInt(sp1[1]), Integer.parseInt(sp2[1])) == 1;
        }
        return Integer.compare(Integer.parseInt(sp1[0]), Integer.parseInt(sp2[0])) == 1;
    }
}
