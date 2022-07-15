package _2weeks0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_1148 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        List<int[]> wordList = new ArrayList<>();
        while (!(str = br.readLine()).equals("-")) {
            int[] temp = new int[26];
            for (int i = 0; i < str.length(); i++) {
                temp[str.charAt(i) - 'A']++;
            }
            wordList.add(temp);
        }

        List<int[]> puzzleList = new ArrayList<>();
        while (!(str = br.readLine()).equals("#")) {
            int[] temp = new int[26];
            for (int i = 0; i < str.length(); i++) {
                temp[str.charAt(i) - 'A']++;
            }
            puzzleList.add(temp);
        }

        for (int[] cnts : puzzleList) {
            List<Data> dataList = new ArrayList<>();
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (cnts[i] == 0) {
                    continue;
                }

                int temp = 0;
                label:
                for (int[] wordCnt : wordList) {
                    if (cnts[i] < wordCnt[i] || wordCnt[i] == 0) {
                        continue;
                    }

                    for (int j = 0; j < 26; j++) {
                        if (cnts[j] < wordCnt[j]) {
                            continue label;
                        }
                    }

                    temp++;
                }
                max = Math.max(max, temp);
                min = Math.min(min, temp);
                dataList.add(new Data((char) ('A' + i), temp));
            }
            Collections.sort(dataList);

            for (Data data : dataList) {
                if (data.cnt == min) {
                    bw.append(data.alphabet);
                }
            }
            bw.append(" ").append(String.valueOf(min)).append(" ");

            for (Data data : dataList) {
                if (data.cnt == max) {
                    bw.append(data.alphabet);
                }
            }
            bw.append(" ").append(String.valueOf(max)).append('\n');
        }

        bw.close();
        br.close();
    }

    static class Data implements Comparable<Data> {
        char alphabet;
        int cnt;

        public Data(char alphabet, int cnt) {
            this.alphabet = alphabet;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Data o) {
            if (cnt == o.cnt) {
                return Character.compare(alphabet, o.alphabet);
            }
            return Integer.compare(cnt, o.cnt);
        }
    }
}
