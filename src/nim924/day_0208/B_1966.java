package day_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("C:\\SSAFY\\workspace\\03_AL\\1_AL\\src\\day04_0208\\hw\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<int[]> queue = new LinkedList<int[]>();
			String s = br.readLine();
			st = new StringTokenizer(s);
			int max=0;
			int[] arr = new int[N];
			for(int j=0; j<N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[j] = temp;
				queue.offer(new int[] {j,temp});
			}
			Arrays.sort(arr);
			int cnt=0;
			while(!queue.isEmpty()) {
				if(queue.peek()[1] >= arr[N-1-cnt]) {
					cnt++;
					int m = queue.poll()[0];
					if(m== M) {
						System.out.println(cnt);
						break;
					};
				}else {
					queue.offer(queue.poll());
				}
			}
			
		}

	}

}
