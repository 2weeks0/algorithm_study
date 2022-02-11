package day_0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1182 {

	static int N,S,arr[],cnt;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		recursive(0,0);
		if(S==0) {
			System.out.println(cnt-1);
		}else {
			System.out.println(cnt);
		}
	}
	
	public static void recursive(int idx,int sum) {
		
		if(idx == N) {
			if(sum == S) {
				cnt++;
			}
			return ;
		}
		
		
		recursive(idx+1, sum+arr[idx]);
		recursive(idx+1, sum);
	}

}
