package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q069 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		reader.close();
		long N = Integer.parseInt(strs[0]);
		final int K = Integer.parseInt(strs[1]);
		int e97 = (int)1e9+7;
		long ans = (K*(K-1))%e97;
		long n = N-2;
		
		return ans;
	}
	
	private static long modPow(long x, long n,long Mod) {
		if(n < 1) {
			return 0;
		}
		long k = 1;
		while( n > 1 ) {
			if( n%2 == 1 ) k *= x;
			x *= x;
			n /= 2;
			x %= Mod;
			k %= Mod;
		}
		
		return (k*x)%Mod;
	}
}
