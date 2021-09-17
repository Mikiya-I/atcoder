package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class q084{
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		final char[] arr = reader.readLine().toCharArray();
		reader.close();
		
		long[] dp = new long[N+1];
		long maxOIdx = -1;
		long maxXIdx = -1;
		for(int i= 0;i<N;i++) {
			if(arr[i] == 'o'){
					maxOIdx = i;
					dp[i+1] = dp[i]+ maxXIdx +1;
			}else {
				maxXIdx = i;
				dp[i+1] = dp[i]+ maxOIdx +1;
			}
		}
		
		return dp[N];
	}
	
}