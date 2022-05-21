package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1897 {
    static int d = -1;
    static String answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        String baseWord = st.nextToken();

        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < d; i++) {
            String word = br.readLine();
            if (map.containsKey(word.length())) {
                map.get(word.length()).add(word);
            } else {
                List<String> list = new LinkedList<>();
                list.add(word);
                map.put(word.length(), list);
            }
        }

        dfs(map, new HashSet<>(), baseWord, 0);

        System.out.println(answer);
        br.close();
    }

    static void dfs(Map<Integer, List<String>> map, Set<String> visited, String word, int depth) {
        if (d < depth) {
            answer = word;
            d = depth;
        }

        visited.add(word);
        if (!map.containsKey(word.length() + 1)) {
            return;
        }

        for (String next : map.get(word.length() + 1)) {
            if (visited.contains(next) || !possible(word, next)) {
                continue;
            }
            dfs(map, visited, next, depth + 1);
        }
    }

    static boolean possible(String word, String next) {
        if (next.contains(word)) {
            return true;
        }

        int idxWord = 0;
        int idxNext = 0;
        while (idxWord < word.length() && idxNext < next.length()) {
            if (word.charAt(idxWord) == next.charAt(idxNext)) {
                idxWord++;
            }
            idxNext++;
        }
        return idxWord == word.length() && idxNext == next.length();
    }
}
