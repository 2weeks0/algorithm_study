package day_0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1747 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		while(true) {
			boolean isPrime = true; 
			int sqrt = (int) Math.sqrt(num);
			for(int i=2; i<sqrt; i++) {
				if(num%i == 0) {
					isPrime = false;
					break;
				}else {
					continue;
				}
			}
			
			if(isPrime) {
				String s = Integer.toString(num);
				
				boolean isPel = true; 
				for(int i=0; i<=s.length()/2; i++) {
					if(s.charAt(i) != s.charAt(s.length()-1-i)) {
						isPel = false;
					}
				}
				if(isPel == true) {
					System.out.println(num);
					return;
				}
			}
			
			num ++;
			
		}

	}

}
