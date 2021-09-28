package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q008 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long mod = (long) (1e9+7);
		char[] str = "atcoder".toCharArray();
		final int N = Integer.parseInt(reader.readLine());
		char[] arr = reader.readLine().toCharArray();
		reader.close();
		
		//n番目の要素まで使って文字列のそれぞれの部分を何個作れるか
		long[][] dp= new long[N+1][8];
		dp[0][0]= 1;
		for(int i=1;i<=N;i++) {
			dp[i][0] = 1;
			for(int j=0;j<7;j++) {
				if(arr[i-1] == str[j]) {
					dp[i][j+1] += dp[i][j];
				}
				dp[i][j+1] += dp[i-1][j+1];
				dp[i][j+1]%= mod;
			}
		}
		
		return dp[N][7];
	}
}
