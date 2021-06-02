package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner185_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		if(M == 0) {
			return 1;
		}
		int[] arr = new int[M];
		strs = reader.readLine().split(" ");
		for(int i= 0;i<M;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		if(arr[0]>1) {
			min = Integer.min(min, arr[0]-1);
		}
		for(int i=1;i<M;i++) {
			if(arr[i]-arr[i-1] >1) {
				min = Integer.min(min, arr[i]-arr[i-1]-1);
			}
		}
		if(N-arr[M-1]>0) {
			min = Integer.min(min, N-arr[M-1]);
		}
		
		int ans = 0;
		if(arr[0]>1) {
			ans +=( arr[0]-1)/min;
			if((arr[0]-1 ) % min  != 0){
				ans ++;
			}
		}
		for(int i=1;i<M;i++) {
			int tmp = arr[i]-arr[i-1]-1;
			if(tmp >0) {
				ans += tmp/min;
				if(tmp % min != 0) {
					ans++;
				}
			}
		}
		if(N-arr[M-1] > 0) {
			ans += (N-arr[M-1])/min;
			if((N-arr[M-1])% min != 0) {
				ans++;
			}
		}
		//↓メモリオーバー？
//		boolean[] grid = new boolean[N+1];
//		strs = reader.readLine().split(" ");
//		for(int i=0;i<M;i++) {
//			grid[Integer.parseInt(strs[i])]=true;
//		}
//		long ans =0;
//		int tmp = 0;
//		int min = Integer.MAX_VALUE;
//		for(int i=1;i<=N;i++) {
//			if(!grid[i] && i!= N) {
//				tmp++;
//			}else if(tmp != 0 || i == N){
//				if(!grid[i] ){
//					tmp++;
//				}
//				if(tmp != 0) {
//					min = Math.min(min, tmp);
//					tmp=0;
//				}
//			}
//		}
//		
//		for(int i=1;i<=N;i++) {
//			if(!grid[i] && i!=N) {
//				tmp++;
//			}else if(tmp != 0 || i==N){
//				if(i==N && !grid[i]) {
//					tmp++;
//				}
//				if(tmp != 0) {
//					ans += tmp/min;
//					if(tmp %min != 0) {
//						ans++;
//					}
//					tmp=0;
//				}
//			}
//		}
		
		return ans;
	}
}
