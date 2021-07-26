package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Beginner211_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long mod = (long) (1e9+7);
		char[] str = reader.readLine().toCharArray();
		reader.close();
		final char[]	 S= "chokudai".toCharArray();
		int[][] dp = new int[8+1][str.length+1];
		
		Arrays.fill(dp[0], 1);
		for(int i=1;i<=8;i++) {
			for(int j=1;j<=str.length;j++) {
				if(str[j-1]==S[i-1]) {
					int x= (int)(((long) dp[i-1][j]+(long)dp[i][j-1])%mod);
					dp[i][j]= x;
				}else {
					dp[i][j]=dp[i][j-1];
				}
			}
		}
		return dp[8][str.length];
	}
}
