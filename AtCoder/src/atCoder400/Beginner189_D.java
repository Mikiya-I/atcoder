package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner189_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		boolean[] arr = new boolean[N];
		for(int i=0;i<N;i++) {
			//or
			if(reader.readLine().length() == 2) {
				arr[i] =true;
			}
		}
		
		long ans = recursion(arr, N-1);
		return ans;
	}
	
	public static long recursion(boolean[] arr,int i) {
		if(i ==-1) {
			return 1;
		}else {
			//or
			if(arr[i]) {
				//ここでオーバーフロー
//				return recursion(arr,i-1)+(long) (1<<i+1)/2;
				return recursion(arr,i-1)+(long)Math.pow(2, i+1);
			}else {
				return recursion(arr,i-1);
			}
		}
	}
}
//テスト用
//40
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
//OR
