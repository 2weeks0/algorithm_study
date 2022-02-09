package study.d0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14891 {
	static List<List<Character>> tops = new LinkedList<>();
	static int[] rotate;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans = 0;
		tops.add(new LinkedList<>());
		for(int i=1;i<5;i++) {
			LinkedList<Character> tmp = new LinkedList<>();
			char[] C = br.readLine().toCharArray();
			for(char c : C) tmp.add(c);
			tops.add(tmp);
		}
		int K = Integer.parseInt(br.readLine());
		while(K --> 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) , way = Integer.parseInt(st.nextToken());
			rotate = new int[] {0,0,0,0,0};
			rotate(num,way);
			for(int i=1;i<5;i++) {
				if(rotate[i] != 0) {
					Collections.rotate(tops.get(i), rotate[i]);
				}
			}
		}
		for(int i=1;i<5;i++) {
			if((char)tops.get(i).get(0)=='1') ans += Math.pow(2, i-1);
		}
		System.out.print(ans);
	}
	static void rotate(int num, int way) {
		if(rotate[num] != 0) return;
		rotate[num] = way;
		if(num !=1 && (char)tops.get(num-1).get(2) != (char)tops.get(num).get(6)) {
			rotate(num-1,way==1 ? -1 : 1);
		}
		if(num !=4 && (char)tops.get(num+1).get(6) != (char)tops.get(num).get(2)) {
			rotate(num+1,way==1 ? -1 : 1);
		}
	}
}
