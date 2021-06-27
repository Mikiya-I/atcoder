package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner169_D {
	public static void main(String[] args) throws IOException {
//		slove();
		long  ans = slove();
		System.out.println(ans);
//		System.out.println(isPrime());
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long N =Long.parseLong(reader.readLine());
		if(N==1) {
			return 0;
		}
		long ans =0;
		
		long root = (long) Math.sqrt(N);
		for(int i=2;i<=root;i++) {
			if(N%i==0) {
				if(isPrime(i)) {
					long div = i;
					long tmp = N;
					while(tmp % div==0) {
						ans++;
						tmp /=div;
						div*=i;
					}
				}
				if(isPrime(N/i)){
					long div = N/i;
					long tmp = N;
					while(tmp % div==0) {
						ans++;
						tmp /=div;
						div*=N/i;
					}
				}
			}
		}
		if(isPrime(N)) {
			 ans++;
		}
		return ans;
	}
	
	public static boolean isPrime(long x) {
		if(x !=2 && x%2==0) {
			return false;
		}else if(x==2) {
			return true;
		}
		for(int i=3;i<=Math.sqrt(x);i+=2) {
			if(x%i==0) {
				return false;
			}
		}
		return true;
	}
}
