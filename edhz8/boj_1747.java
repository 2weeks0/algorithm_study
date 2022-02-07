package study.d0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1747 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(true) {
			String NN = Integer.toString(N);
			int index = -1 , len = NN.length();
			boolean PALIN = true;
			while(++index<=len/2) {
				if(NN.charAt(index) != NN.charAt(len-1-index)) {
					PALIN = false;
					break;
				}
			}
			if(PALIN && isPrime(N)) {
				System.out.print(N);
				break;
			}
			N++;
		}
	}
    public static boolean isPrime(int n){
    	if(n == 2) return true;
        if(n<2 || n%2==0) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2)if(n%i==0) return false;
        return true;
    }
}
