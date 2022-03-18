package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_6987 {
    static final int[][] game = {
            {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4},
            {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5},
    };
    static boolean possible;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[6][3];
        outer:
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 6; j++) {
                if (Arrays.stream(arr[j]).sum() != 5) {
                    sb.append("0 ");
                    continue outer;
                }
            }

            possible = false;
            recursive(arr, new int[6][3], 0);
            sb.append(String.format("%d ", possible ? 1 : 0));
        }
        System.out.println(sb);
        br.close();
    }

    static void recursive(int[][] arr, int[][] temp, int idx) {
        if (possible) {
            return;
        } else if (idx == 15) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] != temp[i][j]) {
                        return;
                    }
                }
            }
            possible = true;
            return;
        }

        int a = game[0][idx];
        int b = game[1][idx];

        temp[a][0]++;
        temp[b][2]++;
        recursive(arr, temp, idx + 1);
        temp[a][0]--;
        temp[b][2]--;

        temp[a][1]++;
        temp[b][1]++;
        recursive(arr, temp, idx + 1);
        temp[a][1]--;
        temp[b][1]--;

        temp[a][2]++;
        temp[b][0]++;
        recursive(arr, temp, idx + 1);
        temp[a][2]--;
        temp[b][0]--;
    }
}

