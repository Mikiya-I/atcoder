package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner165_D {
	public static void main(String[] args) throws IOException {
//		slove();
		long  ans = slove();
		System.out.println(ans);
//		System.out.println(isPrime());
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String [] strs = reader.readLine().split(" ");
		final long A = Long.parseLong(strs[0]);
		final long B = Long.parseLong(strs[1]);
		final long X = Long.parseLong(strs[2]);
		
		long x;
		if(X>=B) {
			x=B-1;
		}else {
			x=X;
		}
		
		long ans = (A*x/B);
		return ans;
	}
}
