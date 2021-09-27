package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner220_D {

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
				slove();
//		System.out.println(slove2());
	}

	public static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final long mod = 998244353;
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		reader.close();
//		int[] beforeCnt = new int[10];
//		int[] tmpCnt = new int[10];
		int[][] dp = new int[N][10];
		int x= Integer.parseInt(strs[0]);
		int y= Integer.parseInt(strs[1]);
		dp[1][ (x+y)%10] ++;
		dp[1][ (x*y)%10] ++;
		for(int i=2;i<N;i++) {
			y= Integer.parseInt(strs[i]);
			for(int j=0;j<10;j++) {
				if(dp[i-1][j]==0)
					continue;
				int f =  (j+y)%10;
				int g = (j*y)%10;
				dp[i][f] += dp[i-1][j] ;
				dp[i][f]  %= mod;
				dp[i][g] += dp[i-1][j];
				dp[i][g] %= mod;
			}
		}
		
		for(int ans: dp[N-1])
			System.out.println(ans);
	}
}
