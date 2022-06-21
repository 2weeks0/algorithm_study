package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_5904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(3);

        while (idx > list.get(list.size() - 1)) {
            list.add(2 * list.get(list.size() - 1) + 3 + list.size());
        }

        System.out.println(recursive(list, list.size() - 1, idx));

        br.close();
    }

    static char recursive(List<Integer> list, int n, int idx) {
        if (n == 0) {
            return idx == 1 ? 'm' : 'o';
        }

        if (idx <= list.get(n - 1)) {
            return recursive(list, n - 1, idx);
        } else if (list.get(n - 1) + n + 3 < idx) {
            return recursive(list, n - 1, idx - (list.get(n - 1) + n + 3));
        } else if (list.get(n - 1) + 1 == idx) {
            return 'm';
        } else {
            return 'o';
        }
    }

}
