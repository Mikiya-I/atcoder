package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class q038 {
	public static void main(String[] args) throws IOException {
		slove();
//		System.out.println(slove());
	}
	
	public static void slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		long a = Long.parseLong(strs[0]);
		long b = Long.parseLong(strs[1]);
		
		long e18 = (long)1e18;
		long cd = gcd(a,b);
		BigInteger A = new BigInteger(strs[0]);
		BigInteger B = new BigInteger(strs[1]);
		BigInteger C = BigInteger.valueOf(cd);
		BigInteger E18 = BigInteger.valueOf(e18);
//		if(a/cd > e18/ b)
//			System.out.println("Large");
//		else
//			System.out.println(Math.max(a, b));
		BigInteger AB = A.multiply(B);
		BigInteger ABC = AB.divide(C);
		if(ABC.compareTo(E18) > 0)
			System.out.println("Large");
		else
			System.out.println(ABC);
	}
	
	private static long gcd(long a,long b) {
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		long mod = max%min;
		while(mod != 0) {
			max = min;
			min = mod;
			mod = max% min;
		}
		
		return min;
	}
}
