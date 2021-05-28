package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner190_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final long N = Long.parseLong(reader.readLine());
		final long n2 = N*2;
		long log = (long) Math.sqrt(n2)+1;
		
		long ans =0;
		for(int i=1;i<log;i++) {
			if(n2%i==0 ) {
				long y = n2/i;
				if((n2/i-i) %2 != 0  )
					ans++;
				if((n2 /y-y)%2 !=0)
					ans ++;
			}
		}
		
		return ans;
	}
}
