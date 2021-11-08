package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class q085{
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final long N = Long.parseLong(reader.readLine());
		reader.close();
		long ans = 0;
		
		int max = (int) Math.cbrt(N);
		for(int i=1;i<=max;i++) {
			if(N%i== 0) {
				long tmp = N/i;
				long loop = (long) Math.sqrt(tmp);
				for(int j=i;j<=loop;j++) {
					if(tmp%j==0)
						ans++;
				}
			}
		}
		
		return ans;
	}
	
}