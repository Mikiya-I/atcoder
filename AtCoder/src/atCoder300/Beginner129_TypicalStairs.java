package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner129_TypicalStairs {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long ans =slove();
		System.out.println(ans);
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		long mod = (long) (1e9+7);
		boolean[] step =new  boolean[N+1];
		for(int i= 0;i<M;i++) {
			step [Integer.parseInt(reader.readLine())]=true;
		}
		int dp[] = new int[N+1];
		dp[0]=1;
		if(!step[1])
			dp[1]=1;
		for(int  i= 2;i<=N;i++) {
			dp[i]+= step[i-1]?0:dp[i-1];
			dp[i]+= step[i-2]?0:dp[i-2];
			if(dp[i]==0)
				return 0;
			dp[i] %= mod;
		}
		
		return dp[N];
	}
}
