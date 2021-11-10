package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q001_2 {
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
		strs = reader.readLine().split(" ");
		reader.close();
		int[] eachLength = new int[N];
		int[] points = new int[N];
		points[0] = Integer.parseInt(strs[0]);
		eachLength[0] = points[0];
		
		for(int i=1;i<N;i++) {
			points[i] = Integer.parseInt(strs[i]);
			eachLength[i] = points[i]-points[i-1];
		}
//		eachLength[N-1]+=L-points[N-1];
		
		long ans = binarySearch(eachLength, K, L);
		
		return ans;
	}
	
	private static long binarySearch(int[] arr,int k,int total) {
		long ok = -1;
		long ng = total+1;
		while(ng - ok > 1) {
			long mid = (ok +ng)/2;
			if(checkPossible(arr,mid ,total,k)) {
				ok=mid;
			}else {
				ng = mid;
			}
			
		}
		return ok;
	}
	
	private static boolean checkPossible(int[] arr,int length,int k) {
		int cnt =0;
		int tmp =0;
		for(int i:arr) {
			if(tmp+i>=length) {
				cnt++;
				tmp=0;
			}
			else
				tmp+=i;
		}
		return cnt>=k;
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
