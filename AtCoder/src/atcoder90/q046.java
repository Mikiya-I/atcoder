package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q046 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());

		long[] arrA = new long[46];
		long[] arrB = new long[46];
		long[] arrC = new long[46];
		
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int mod = Integer.parseInt(strs[i])%46;
			arrA[mod]++;
		}
		
		strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int mod = Integer.parseInt(strs[i])%46;
			arrB[mod]++;
		}
		
		strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int mod = Integer.parseInt(strs[i])%46;
			arrC[mod]++;
		}
		
		long ans = 0;
		for(int i=0;i<46;i++) {
			for(int j=0;j<46;j++) {
				for(int k=0;k<46;k++) {
						if((i+j+k)%46 == 0)
							ans += arrA[i]*arrB[j]*arrC[k];
				}
			}
		}
		
		return ans;
	}
}
