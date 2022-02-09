package study.d0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1966 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int t=0;t<TC;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()),M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ArrayList<int[]> q = new ArrayList<>();
			for(int i=0;i<N;i++) q.add(new int[] {i,Integer.parseInt(st.nextToken())});
			int count = 0;
			while(true) {
				int index = q.get(0)[0] , score = q.get(0)[1];
				boolean POP = true;
				for(int[] d : q) {
					if(score<d[1]) {
						POP = false;
						break;
					}
				}
				if(POP) {
					count++;
					if(index == M) {
						System.out.println(count);
						break;
					}
					q.remove(0);
				} else {
					Collections.rotate(q, -1);
				}
			}
		}
	}
}
