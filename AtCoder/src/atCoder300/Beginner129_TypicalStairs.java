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
		long ans = 0;
		long mod = (long) (1e9+7);
		boolean[] step =new  boolean[N];
		for(int i= 0;i<M;i++) {
			step [Integer.parseInt(reader.readLine())]=true;
		}
		int start =0;
		for(int i=0;i<N;i++) {
			if(step[i]) {
				//2段連続していたら0
				if(i-start==0) {
					return 0;
				}
				//対象の段数
				int stepCount = (i-start);
				//2段の最大値
				int twoCount = stepCount/2;
				// 全部1段ずつのパターン
				ans++;
				for(int j= 1;i<twoCount;i++) {
					ans +=  modFactorial(stepCount-j,mod)/(modFactorial(,mod)*modFactorial(, mod));
					ans %= mod;
				}
				start = i+1;
			}
		}
		return 1;
	}
	
	public static long modFactorial(int n,long mod) {
		long ans=1;
		while(n==1) {
			ans*=n--;
			ans%=mod;
		}
		return ans;
	}
}
