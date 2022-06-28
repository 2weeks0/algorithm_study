package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1105 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String l = st.nextToken();
        String r = st.nextToken();

        int answer = 0;
        if (l.length() == r.length()) {
            for (int i = 0; i < l.length(); i++) {
                if (l.charAt(i) == r.charAt(i) && l.charAt(i) == 8) {
                    answer++;
                } else if (l.charAt(i) != r.charAt(i)) {
                    break;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
