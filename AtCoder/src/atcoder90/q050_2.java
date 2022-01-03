package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q050_2 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int L = Integer.parseInt(strs[1]);
		long mod = (long)1e9+7;
		if(N < L) {
			return 1;
		}
		
		long[] dp = new long[N+1];
		for(int i=0;i<L;i++) {
			dp[i] = 1;
		}
		
		for(int i=L;i<=N;i++) {
			dp[i] = dp[i-1]+dp[i-L];
			dp[i] %= mod;
		}
		return dp[N];
	}
}
