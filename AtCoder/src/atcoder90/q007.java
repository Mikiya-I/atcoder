package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q007 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(reader.readLine());
		int[] classLevels = new int[N];
		String[] strs =reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			classLevels[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(classLevels);
		
		final int Q = Integer.parseInt(reader.readLine());
		
		for(int i=0;i<Q;i++) {
			int tmp= Integer.parseInt(reader.readLine());
			sb.append(binarySearch(classLevels, tmp));
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static int binarySearch(int[] arr,int num) {
		int left = -1;
		int right = arr.length;
		while(right-left > 1) {
			int mid = (left+right)/2;
			if(arr[mid]> num)
				right = mid;
			else if (arr[mid] < num)
				left = mid;
			else
				return 0;
		}
		
		if(left == -1)
			return  Math.abs(num- arr[right]);
		else if ( right == arr.length)
			return Math.abs(num-arr[left]);
		
		
		return Math.min(Math.abs(num-arr[right]), Math.abs(num-arr[left]));
	}
}
