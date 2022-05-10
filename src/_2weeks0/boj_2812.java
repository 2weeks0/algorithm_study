package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2812 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = str.charAt(i) - '0';
            while (0 < k && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse().substring(0, sb.length() - k));
        br.close();
    }
}
