package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_10775 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int[] set = makeSet(g + 1);
        int i;
        for (i = 0; i < p; i++) {
            int gi = Integer.parseInt(br.readLine()) ;
            int parent = findSet(set, gi);
            if (parent == 0) {
                break;
            }
            unionSet(set, Math.max(parent - 1, 0), gi);
        }

        System.out.println(i);
        br.close();
    }

    static int[] makeSet(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }

    static int findSet(int[] set, int a) {
        if (a == set[a]) {
            return a;
        }
        return set[a] = findSet(set, set[a]);
    }

    static void unionSet(int[] set, int a, int b) {
        int rootA = findSet(set, a);
        int rootB = findSet(set, b);
        if (rootA == rootB) {
            return;
        }
        set[rootB] = rootA;
    }
}
