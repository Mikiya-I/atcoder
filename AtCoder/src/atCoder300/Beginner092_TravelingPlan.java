package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner092_TravelingPlan {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String ans = slove();
		System.out.println(ans);
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int  N   = Integer.parseInt(reader.readLine());
		
		int[] nums = new int[N+2];
		int[] sums = new int[N+2];
		String[] str = reader.readLine().split(" ");
		for(int i=1;i<=N;i++) {
			nums[i] = Integer.parseInt(str[i-1]);
			sums[i] = sums[i-1]+Math.abs(nums[i-1]-nums[i]);
		}
		sums[N+1] = sums[N]+Math.abs(nums[N]);
		int total = sums[N+1];
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			int tmp = total - Math.abs(nums[i]-nums[i-1]) - Math.abs(nums[i]-nums[i+1]);
			tmp += Math.abs(nums[i+1]-nums[i-1]);
			sb.append(tmp);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
