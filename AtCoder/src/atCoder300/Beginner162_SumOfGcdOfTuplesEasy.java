package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner162_SumOfGcdOfTuplesEasy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int K = Integer.parseInt(reader.readLine());
		long ans = 0;
		for(int i = 1;i <= K; i++) {
			for(int j= 1; j<= K; j++) {
				for(int k = 1; k<=K;k++) {
					int tmp = gcd(j,k);
					ans += gcd(tmp,i);
				}
			}
		}
		
		return ans;
	}
	
	public static int gcd(int x,int y) {
		if(x == 0) {
			return y;
		}
		if(y == 0) {
			return x;
		}
		int max = x>=y?x:y;
		int min = x<y?x:y;
		int mod = max%min;
		while(mod != 0) {
			max = min;
			min = mod;
			mod = max %  min;
		}
		return min;
	}
}
