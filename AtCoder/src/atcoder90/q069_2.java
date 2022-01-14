package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class q069_2 {
	
	static long N,K;
	static long mod = (long) 1e9+7;
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Long.parseLong(strs[0]);
		K = Long.parseLong(strs[1]);
		reader.close();
	}
	
	public static long slove() throws  IOException {
		if(N == 1)
			return K;
		if(N==2) {
			return (K*(K-1))%mod;
		}
		long ans = (K*(K-1)) %mod;
		BigInteger x = new BigInteger(String.valueOf(K-2));
		x = x.modPow(new BigInteger(String.valueOf(N-2)),new BigInteger( String.valueOf(mod)));
		ans *= x.longValue();
		ans %= mod;
			
		return ans;
	}
}
