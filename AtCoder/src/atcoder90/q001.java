package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q001 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int L = Integer.parseInt(strs[1]);
		final int K = Integer.parseInt(reader.readLine());
		int[] arr = new int[N];
		strs = reader.readLine().split(" ");
		arr[0] = Integer.parseInt(strs[0]);
		for(int i=1;i<N;i++)
			arr[i] = Integer.parseInt(strs[i]) - Integer.parseInt(strs[i-1]);
		
		long ans = binarySearch(arr, L, K);
		
		
		return ans;
	}
	
	private static long binarySearch(int[] arr,int l,int k) {
		long ok = -1;
		long ng = l+1;
		while(ng - ok > 1) {
			long mid = (ok + ng)/2;
			if(checkPossible(arr, mid, l, k))
				ok = mid;
			else
				ng = mid;
		}
		return ok;
	}

	private static boolean checkPossible(int[] arr,long x,int l,int k) {
		int sum = 0;
		int total = 0;
		int cnt =0;
		for(int i=0;i<arr.length;i++) {
			sum+= arr[i];
			total += arr[i];
			int min = Math.min(sum, l-total);
			if(min >= x){
				sum =0;
				cnt++;
			}
		}
		
		return cnt >= k;
	}
}
