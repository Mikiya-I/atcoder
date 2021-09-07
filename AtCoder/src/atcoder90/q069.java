package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q069 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		reader.close();
		long N = Long.parseLong(strs[0]);
		final long K = Long.parseLong(strs[1]);
		if(N==1) {
			return K;
		}
		long e97 = (long)1e9+7;
		long ans = (K*(K-1))%e97;
		long n = N-2;
		ans *= modPow(n, K-2, e97);
		ans %= e97;
		return ans;
	}
	
	//x:基数　
	private static long modPow(long n, long x,long mod) {
		long ans = 1;
		//基数の乗数
		long tmp=x;
		//nをビット列として扱う
		while(n>0) {
			if((n & 1)==1)  {
				ans *= tmp;
				ans %= mod;
			}
			tmp *= tmp;
			tmp %= mod;
			n = n>>1;
		}
		
		return ans;
	}
}
