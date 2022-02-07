package study.d0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1182 {
	static int[] nums;
	static int N,S;
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NS = new StringTokenizer(br.readLine());
		N = Integer.parseInt(NS.nextToken());
		S = Integer.parseInt(NS.nextToken());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i=0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		rec(0,0);
		System.out.print(S==0 ? ans-1 : ans);
	}
	public static void rec(int sum,int i) {
		if(i==N) {
			if(sum == S) ans++;
			return;
		}
		if(nums[i]>0 && sum>S) return;
		rec(sum+nums[i] , i+1);
		rec(sum, i+1);
	}
}
