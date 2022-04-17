
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner248_C {
	static int N,M,K;
	static int mod = 998244353;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		K = Integer.parseInt(strs[2]);
		reader.close();
	}

	public static long slove() throws IOException {
		long ans = 0;
		//N番目にMが入っている数列の数
		long[][] dp =  new long[N][N*M+1];
		for(int k=1;k<=M;k++) {
			if(k <= M) {
				dp[0][k]++;
			}
		}
		for(int i=1;i<N;i++) {
			for(int j=1;j<N*M+1;j++) {
				long cnt = dp[i-1][j];
				if(cnt==0)
					continue;
				for(int k=1;k<=M;k++) {
					int tmp = j + k;
					if(tmp <= K) {
						dp[i][(int) tmp]+= cnt;
						dp[i][tmp] %= mod;
					}
				}
			}
		}
		
		for(long l:dp[N-1]) {
			if(l > 0) {
				ans += l;
				ans %= mod;
			}
		}
		
		return ans;
	}
	
}