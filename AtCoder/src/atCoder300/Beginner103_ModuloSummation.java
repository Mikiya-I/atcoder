package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner103_ModuloSummation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long ans = slove();
		System.out.println(ans);
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		
		int[] nums = new int[N];
		long ans =0;
		for(int i= 0;i<N;i++) {
			nums[i] = Integer.parseInt(strs[i]);
			ans += nums[i]-1;
		}
		
		
		return ans;
	}
}