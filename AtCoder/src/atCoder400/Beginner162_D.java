package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner162_D {
	public static void main(String[] args) throws IOException {
//		slove();
		long  ans = slove();
		System.out.println(ans);
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		char[]arr = reader.readLine().toCharArray();
		int[] rSums = new int[N+1];
		int[] gSums = new int[N+1];
		int[] bSums =new int[N+1];
		
		for(int i=1;i<=N;i++) {
			rSums[i]= rSums[i-1];
			gSums[i] = gSums[i-1];
			bSums[i] = bSums[i-1];
			if(arr[i-1] =='R') {
				rSums[i]++;
			}else if(arr[i-1] == 'G') {
				gSums[i]++;
			}else {
				bSums[i]++;
			}
		}
		long  ans = 0;
		for(int i=1;i<=N;i++) {
			char c= arr[i-1];
			if(c=='R') {
				ans += gSums[i]*bSums[i];
			}else if( c== 'G') {
				ans += rSums[i] * bSums[i];
			}else {
				ans += rSums[i] * gSums[i];
			}
		}
		
		for(int i=0;i<N;i++) {
			char si = arr[i];
			for(int j=i+1;j<N;j++) {
				char sj= arr[j];
				if(si != sj) {
					int k= j + j-i;
					if( k <N && arr[k] != si && arr[k] != sj) {
						ans --;
					}
				}
			}
		}
		return ans;
	}
}
