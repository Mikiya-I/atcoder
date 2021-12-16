package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q042_2 {

	static int K;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
//		 slove();
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(reader.readLine());
		reader.close();
	}

	static long slove() throws IOException {
		if(digitSum(K) %9 != 0)
			return 0;
		//各桁の合計の通り数(dp[100]は各桁の合計が100になる数の通り数)
		long[] dp = new long[K+1];
		long mod = (long)1e9+7;
		dp[0] = 1;
		for(int i=0;i<K+1;i++) {
			for(int j=1;j<= 9 && i+j <= K;j++) {
				int tmp = i+j;
				if(tmp<=K) {
					dp[tmp] += dp[i];
					dp[tmp]%= mod;
				}
			}
		}
		return dp[K];
    }
	
	static int digitSum(int x) {
		int sum = 0;
		while(x>0) {
			sum+= x%10;
			x/=10;
		}
		return sum;
	}
}