package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner161_ReplacingInteger {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = reader.readLine().split(" ")	;
		final long N = Long.parseLong(strs[0]);
		final long  K = Long.parseLong(strs[1]);
		long ans = 0;
		ans = Math.min(N%K, Math.abs(N%K-K));
		
		return ans ;
	}
}
