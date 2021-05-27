package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner186_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		final String[] strs = reader.readLine().split(" ");
		long[] arr = new long[N];
		long[] sums = new long[N];
		
		arr[0] = Long.parseLong(strs[0]);
		for(int i=1;i<N;i++) {
			arr[i] = Long.parseLong(strs[i]);
		}
		//並びを変えても答えは変わらない(全部の組み合わせが一回ずつ出るだけのため)
		Arrays.sort(arr);
		long ans =0;
		sums[0] = arr[0];
		for(int i=1;i<N;i++) {
			sums[i] = sums[i-1] + arr[i];
		}
		
		for(int i=0;i<N;i++) {
			ans += (sums[N-1] - sums[i])  - arr[i] * (N-i-1);
		}
		
		return ans;
	}
}
