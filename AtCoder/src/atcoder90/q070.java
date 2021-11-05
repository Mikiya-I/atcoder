package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q070 {
	static long[] x,y;
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N  = Integer.parseInt(reader.readLine());
		x = new long[N];
		y = new long[N];
//		long xSum = 0;
//		long ySum = 0;
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			x[i] = Long.parseLong(strs[0]);
			y[i] = Long.parseLong(strs[1]);
//			xSum += x[i];
//			ySum += y[i];
		}
//		double xAve = (double)xSum / N;
//		double yAve = (double) ySum /N;
//		long xPoint = binarySearch(xAve, x);
//		long yPoint = binarySearch(yAve, y);
		
		Arrays.sort(x);
		Arrays.sort(y);
		double xPoint ;
		double yPoint ;
		if(N%2 == 1) {
			xPoint =  x[N/2];
			yPoint = y[N/2];
		}else {
			xPoint = (double)(x[N/2-1]+x[N/2])/2;
			yPoint = (double)(y[N/2-1]+y[N/2])/2;
		}
		double ans =0;
		for(int i=0;i<N;i++) {
			double xDistance = Math.abs(x[i] - xPoint);
			double yDistance = Math.abs(y[i] - yPoint);
			ans += xDistance;
			ans += yDistance;
		}
		
		return (long) ans;
	}
	
	static long binarySearch(double base,long[] arr) {
		int left=-1;
		int right = arr.length;
		while(right - left > 1) {
			int mid = (left + right)/2;
			if(arr[mid]>=base) {
				right = mid;
			}else {
				left = mid;
			}
		}
		return arr[right];
	}
}
