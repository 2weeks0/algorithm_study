package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj_14369 {
    static final String[] NUMBERS = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            bw.append(String.format("Case #%d: ", t));

            String str = br.readLine();
            int cnts[] = new int[26];
            for (int i = 0; i < str.length(); i++) {
                cnts[str.charAt(i) - 'A']++;
            }

            List<Integer> answer = new ArrayList<>();
            recursive(cnts, answer);
            for (int i : answer) {
                bw.append(String.valueOf(i));
            }
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    static boolean recursive(int[] cnts, List<Integer> answer) {
        if (Arrays.stream(cnts).filter(it -> it == 0).count() == cnts.length) {
            return true;
        }

        outer: for (int i = 0; i < NUMBERS.length; i++) {
            String number = NUMBERS[i];
            int[] temp = new int[26];
            for (int j = 0; j < number.length(); j++) {
                temp[number.charAt(j) - 'A']++;
            }

            for (int j = 0; j < cnts.length; j++) {
                if (cnts[j] < temp[j]) {
                    continue outer;
                }
            }

            for (int j = 0; j < cnts.length; j++) {
                cnts[j] -= temp[j];
            }
            answer.add(i);
            if (recursive(cnts, answer)) {
                return true;
            }
            answer.remove(answer.size() - 1);
            for (int j = 0; j < cnts.length; j++) {
                cnts[j] += temp[j];
            }
        }
        return false;
    }
}
