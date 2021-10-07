package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q042 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long mod = (long)1e9+7;
		final int K = Integer.parseInt(reader.readLine());
		if(K%9!= 0)
			return 0;
		reader.close();
		//各桁の合計
		long[] dp = new long[K+1];
		dp[0] = 1;
		for(int i=0;i<=K;i++) {
			for(int j=1;j<=9 && i+j <=K;j++) {
				dp[i+j] += dp[i];
				dp[i+j] %= mod;
			}
		}
		return dp[K];
	}
}
