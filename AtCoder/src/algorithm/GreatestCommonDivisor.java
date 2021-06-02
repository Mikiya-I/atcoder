package algorithm;

public class GreatestCommonDivisor {
	long gcd(long x,long y) {
		if(x==0) {
			return y;
		}
		if(y==0) {
			return x;
		}
		long max = x>=y?x:y;
		long min = y<=x?y:x;
		long mod = max%min;
		while(mod>0) {
			max=min;
			min=mod;
			mod=max%min;
		}
		
		return min;
	}
}
