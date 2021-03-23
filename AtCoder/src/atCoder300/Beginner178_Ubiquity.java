package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner178_Ubiquity {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		final int N = Integer.parseInt(reader.readLine());
		long ans = slove(N);
		System.out.println(ans);
	}

//		public static long slove(int N) {
//			long base = (long)1e9+7;
//			if(N==1)
//				return 0;
//
//			long ans=1;
//			//並べ方の総数(Nの階乗)
//			for(int i=1;i<=N;i++) {
//				ans*= i;
//				ans%=base;
//			}
//
//			//要素の数(N-2個の要素の数)
//			for(int i=0;i<N-2;i++) {
//				ans*=10;
//				ans%=base;
//			}
//			return ans;
//		}
		public static long slove(int N) {
		long mod = (long)1e9+7;
		if(N==1)
			return 0;
		//全部のパターン
		long total=powMod(10,N,mod);
		//9か0以外のみのパターン
		long removeCase = powMod(9,N,mod);
		//9と0が使われないパターン(重複)
		long duplicateCase = powMod(8,N,mod);
		long ans = total-removeCase-removeCase+duplicateCase;
		ans %= mod;
		//負を正に
		ans = (ans+mod)%mod;
		return ans;
	}

		
		public static long powMod(long base,  int pow,long mod) {
			long ans =1;
			for(int i= 0;i<pow;i++) {
				ans *= base;
				ans%= mod;
			}
			return ans;
		}
}

