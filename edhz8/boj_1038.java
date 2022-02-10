package study.d0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class boj_1038 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()),cnt = 9;
		if(N<10) {
			System.out.print(N);
			return;
		}
		LinkedList<Long> nums = new LinkedList<>(Arrays.asList(0L,1L,2L,3L,4L,5L,6L,7L,8L,9L));
		while(!nums.isEmpty()) {
			long num = nums.poll();
			for(int i=0;i<num%10;i++) {
				if(++cnt == N) {
					System.out.print(num*10+i);
					return;
				}
				else nums.offer(num*10+i);
			}
		}
		System.out.print(-1);
	}
}