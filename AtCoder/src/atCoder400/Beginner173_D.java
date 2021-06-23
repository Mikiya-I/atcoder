package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner173_D {
	public static void main(String[] args) throws IOException {
		
		long  ans = slove();
		System.out.println(ans);
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N =Integer.parseInt(reader.readLine());
		final String[] strs = reader.readLine().split(" ");
		long[] arr = new long[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(arr);
		long ans =0;
		ans+=arr[N-1];
		//1つの要素から2回までその数を出せる
		long currentElement = arr[N-2] ;
		int nextElementIndex = N-3;
		int canUse =2;
		for(int i=N-2;i>0;i--) {
			if(canUse ==0) {
				currentElement=arr[nextElementIndex];
				nextElementIndex --;
				canUse=2;
			}
			ans += currentElement;
			canUse--;
		}
		return ans;
	}
}
