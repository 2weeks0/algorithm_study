package study.d0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10819 {
	static int[] nums;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i=0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			boolean[] checks = new boolean[N];
			checks[i] = true;
			rec(checks,0,i);
		}
		System.out.print(max);
	}
	public static void rec(boolean[] checks, int sum,int next) {
		boolean END = true;
		for(int i=0;i<checks.length;i++) {
			if(!checks[i]) {
				boolean[] tchecks = Arrays.copyOf(checks, checks.length);
				tchecks[i] = true;
				END = false;
				rec(tchecks,sum+Math.abs(nums[next]-nums[i]),i);
			}
		}
		if(END) {
			max = Math.max(max, sum);
			return;
		}
	}
}
