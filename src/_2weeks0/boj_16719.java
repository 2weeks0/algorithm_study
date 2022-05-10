package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_16719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        String s = "";
        boolean[] isUsed = new boolean[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int idx = 0;
            for (int j = 0; j < str.length(); j++) {
                if (isUsed[j]) {
                    continue;
                }
                isUsed[j] = true;
                String temp = getString(str, isUsed);
                if (s.length() < i + 1 || temp.compareTo(s) < 0) {
                    idx = j;
                    s = temp;
                }
                isUsed[j] = false;
            }
            isUsed[idx] = true;
            bw.append(s);
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    static String getString(String str, boolean[] isUsed) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!isUsed[i]) {
                continue;
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
