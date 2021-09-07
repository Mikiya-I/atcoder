package algorithm;

public class ModPow {
	//n:指数部 x:基数 mod:割る数
	private static long modPow(long n, long x, long mod) {
		long ans = 1;
		//基数の乗数
		long tmp = x;
		//nをビット列として扱う
		while (n > 0) {
			if ((n & 1) == 1) {
				ans *= tmp;
				ans %= mod;
			}
			tmp *= tmp;
			tmp %= mod;
			n = n >> 1;
		}

		return ans;
	}
}
