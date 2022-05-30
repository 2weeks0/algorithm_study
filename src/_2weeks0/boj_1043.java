package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1043 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] set = makeSet(n);
        boolean[] knowTruth = new boolean[n];

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            knowTruth[Integer.parseInt(st.nextToken()) - 1] = true;
        }

        int[][] parties = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            parties[i] = new int[k];
            for (int j = 0; j < k; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }

            for (int j = 0; j < k - 1; j++) {
                unionSet(set, knowTruth, parties[i][j], parties[i][j + 1]);
            }
        }

        int answer = 0;
        for (int[] party : parties) {
            if (!knowTruth[findSet(set, party[0])]) {
                answer++;
            }
        }

        System.out.println(answer);
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
        int rootA = set[a];
        if (rootA == a) {
            return a;
        }
        return (set[rootA] = findSet(set, rootA));
    }

    static void unionSet(int[] set, boolean[] knowTruth, int a, int b) {
        int rootA = findSet(set, a);
        int rootB = findSet(set, b);

        if (rootA == rootB) {
            return;
        }

        if (knowTruth[rootA]) {
            set[rootB] = rootA;
        } else {
            set[rootA] = rootB;
        }
    }
}
