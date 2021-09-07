package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q075 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(reader.readLine());
		reader.close();
		long ans = 0;
		if(isPrime(N))
			return 0;
		
		int cnt = 0;
		
		long tmp = 2;
		while(N%tmp == 0) {
			N/=tmp;
			cnt++;
		}
		if(N > 1 && isPrime(N)) {
			N =1;
			cnt ++ ;
		}
		tmp ++;
		while(N >1) {
			if(N%tmp == 0) {
				while(N%tmp == 0) {
					N/=tmp;
					cnt++;
				}
				if(N>1 && isPrime(N)) {
					N = 1;
					cnt++;
				}
			}
			tmp += 2;
		}
		while(cnt > Math.pow(2, ans)) {
			ans++;
		}
		
		return ans;
	}
	
	private static boolean isPrime(long x) {
		long loop = (long) Math.sqrt(x);
		if(x%2 == 0) {
			return x==2;
		}
		for(int i = 3;i<=loop; i+=2) {
			if(x%i == 0)
				return false;
		}
		
		return true;
	}
}
