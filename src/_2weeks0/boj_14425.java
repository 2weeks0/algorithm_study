package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), true);
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (map.containsKey(br.readLine())) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}

//package _2weeks0;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class boj_14425 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        String[] s = new String[n];
//        for (int i = 0; i < n; i++) {
//            s[i] = br.readLine();
//        }
//
//        int answer = 0;
//        outer: for (int i = 0; i < m; i++) {
//            String str = br.readLine();
//            for (int j = 0; j < n; j++) {
//                if (s[j].equals(str)){
//                    answer++;
//                    continue outer;
//                }
//            }
//        }
//
//        System.out.println(answer);
//    }
//}
