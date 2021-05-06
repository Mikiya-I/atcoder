package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner094_ManyMedians {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String ans = slove();
		System.out.println(ans);
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int  N   = Integer.parseInt(reader.readLine());
		
		int[] nums = new int[N];
		String[] str = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		
		int[] forMedian = nums.clone();
		Arrays.sort(forMedian);
		int smallMedian = forMedian[N/2-1];
		int largeMedian = forMedian[N/2];
		
		StringBuilder sb = new StringBuilder();
		for(int tmp:nums) {
			sb.append(tmp<=smallMedian?largeMedian:smallMedian);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
