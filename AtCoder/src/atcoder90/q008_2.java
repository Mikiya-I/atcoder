package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q008_2 {

	static char[] arr;
	static int N,Q;
	static long mod = (long) 1e9+7;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
	}
	
	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(reader.readLine());
//		String[] strs = reader.readLine().split(" ");
		arr = reader.readLine().toCharArray();
		
		reader.close();
	}

	static long slove() {
		long[][] dp = new long[N+1][8];
		dp[0][0] = 1;
		char[] atcoder = " atcoder".toCharArray();
		for(int i = 1;i<=N;i++) {
			char tmp = arr[i-1];
			for(int j = 0;j<8;j++) {
				dp[i][j] = dp[i-1][j];
				if(tmp == atcoder[j]) {
					dp[i][j] += dp[i][j-1];
					dp[i][j] %= mod;
				}
			}
		}
		
		return dp[N][7];
	}
}
