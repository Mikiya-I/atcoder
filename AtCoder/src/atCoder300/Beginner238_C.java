
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner238_C {
	static long N;
	static long mod = 998244353;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(reader.readLine());
		reader.close();
	}

	public static long slove() throws IOException {
		long base = 10;
		long ans = 0;
		while(base-1<N) {
			//その桁の数
			long nums = base-base/10;
			long tmpCnt;
			if((nums %mod )%2 == 1) {
				tmpCnt = (1+nums)%mod/2 *( (nums) %mod);
			}else {
				tmpCnt =  (nums)%mod/2 * ((1+nums)%mod);
			}
			tmpCnt %= mod;
			ans += tmpCnt;
			ans %= mod;
			base *=10;
		}
		long nums = N-base/10 +1;
		long tmpCnt;
		if((nums %mod )%2 == 1) {
			tmpCnt = (1+nums)%mod/2 * ((nums) %mod);
		}else {
			tmpCnt =  (nums)%mod/2 *( (1+nums)%mod);
		}
		tmpCnt %= mod;
		ans += tmpCnt;
		ans %= mod;
		
		return ans;
	}
	
	

}