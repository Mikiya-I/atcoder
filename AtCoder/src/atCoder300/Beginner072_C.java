package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner072_C {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long  ans = slove();
		System.out.println(ans);
	}

	
    public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		final int  N = Integer.parseInt(reader.readLine());
		if(N== 1) {
			return 1;
		}
		String[] strs = reader.readLine().split(" ") ;
		int[] nums = new int[100001];
		for(int i=0;i<N;i++) {
			nums[Integer.parseInt(strs[i])]++;
		}
		int ans = 0;
		for(int i=1;i<100000;i++) {
			ans = Math.max(ans, nums[i-1] + nums[i]+nums[i+1]);
		}
		
		return ans;
    }
}
