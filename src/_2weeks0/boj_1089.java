package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class boj_1089 {
    static double answer = 0f;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[5][4 * n - 1];
        for (int r = 0; r < 5; r++) {
            String line = br.readLine();
            for (int c = 0; c < 4 * n - 1; c++) {
                arr[r][c] = line.charAt(c);
            }
        }
        br.close();

        char[][][] charArr = initCharArray();
        Set<Integer>[] setArr = new HashSet[10];
        for (int i = 0; i < n; i++) {
            setArr[i] = new HashSet<>();
            outer:
            for (int j = 0; j < 10; j++) {
                for (int r = 0; r < 5; r++) {
                    for (int c = 4 * i; c < 4 * i + 3; c++) {
                        if (arr[r][c] == '#' && charArr[j][r][c % 4] == '.') {
                            continue outer;
                        }
                    }
                }
                setArr[i].add(j);
            }
        }

        for (int i = 0; i < n; i++) {
            if (setArr[i].size() == 0) {
                System.out.println(-1);
                return;
            }
            for (int num : setArr[i]) {
                answer += num * Math.pow(10, n - 1 - i) / setArr[i].size();
            }
        }
        System.out.printf("%.5f", answer);
    }

    static char[][][] initCharArray() {
        char[][][] result = new char[10][][];
        for (int i = 0; i < 10; i++) {
            result[i] = initCharArray(i);
        }
        return result;
    }

    static char[][] initCharArray(int n) {
        char[][] result = new char[5][3];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(result[i], '.');
        }

        switch (n) {
            case 0:
                for (int i = 0; i < 5; i++) {
                    result[i][0] = '#';
                    result[i][2] = '#';
                }
                result[0][1] = '#';
                result[4][1] = '#';
                break;
            case 1:
                for (int i = 0; i < 5; i++) {
                    result[i][2] = '#';
                }
                break;
            case 2:
                for (int i = 0; i < 3; i++) {
                    result[0][i] = '#';
                    result[2][i] = '#';
                    result[4][i] = '#';
                }
                result[1][2] = '#';
                result[3][0] = '#';
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    result[0][i] = '#';
                    result[2][i] = '#';
                    result[4][i] = '#';
                }
                result[1][2] = '#';
                result[3][2] = '#';
                break;
            case 4:
                for (int i = 0; i < 5; i++) {
                    result[i][2] = '#';
                }
                result[0][0] = '#';
                result[1][0] = '#';
                result[2][0] = '#';
                result[2][1] = '#';
                break;
            case 5:
                for (int i = 0; i < 3; i++) {
                    result[0][i] = '#';
                    result[2][i] = '#';
                    result[4][i] = '#';
                }
                result[1][0] = '#';
                result[3][2] = '#';
                break;
            case 6:
                for (int i = 0; i < 3; i++) {
                    result[0][i] = '#';
                    result[2][i] = '#';
                    result[4][i] = '#';
                }
                result[1][0] = '#';
                result[3][0] = '#';
                result[3][2] = '#';
                break;
            case 7:
                for (int i = 0; i < 5; i++) {
                    result[i][2] = '#';
                }
                result[0][0] = '#';
                result[0][1] = '#';
                break;
            case 8:
                for (int i = 0; i < 5; i++) {
                    result[i][0] = '#';
                    result[i][2] = '#';
                }
                result[0][1] = '#';
                result[2][1] = '#';
                result[4][1] = '#';
                break;
            case 9:
                for (int i = 0; i < 5; i++) {
                    result[i][0] = '#';
                    result[i][2] = '#';
                }
                result[0][1] = '#';
                result[2][1] = '#';
                result[4][1] = '#';
                result[3][0] = '.';
                break;
        }
        return result;
    }
}
