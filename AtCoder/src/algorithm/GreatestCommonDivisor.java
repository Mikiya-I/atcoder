package algorithm;

public class GreatestCommonDivisor {
	long gcd(long x,long y) {
		if(x==0) {
			return y;
		}
		if(y==0) {
			return x;
		}
		long max = Math.max(x, y);
		long min = Math.min(x, y);
		long mod = max%min;
		while(mod>0) {
			max=min;
			min=mod;
			mod=max%min;
		}
		
		return min;
	}
}
