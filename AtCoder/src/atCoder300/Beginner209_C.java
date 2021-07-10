package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Beginner209_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		reader.close();
		long ans =0;
		long mod = (long) (1e9+7);
		long[] arr = new long[N];
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(strs[i]);
		}
		Arrays.sort(arr);
		ans += arr[0];
		for(int i=1;i<N;i++) {
			ans *= arr[i]-i;
			ans%= mod;
		}
		
		return ans;
	}
}
