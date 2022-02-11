package day_0210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_14425 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 0);
		}
		
		
		int cnt = 0;
		for(int i=0; i<M; i++) {
			if(map.containsKey(br.readLine()) == true) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
