package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner204_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		final String[] strs = reader.readLine().split(" ");
		int[] nums = new int[N];
		int total = 0;
		for(int i= 0;i<N;i++) {
			nums[i] = Integer.parseInt(strs[i]);
			total += nums[i];
		}
		int possibleMax = total/2;
		
		//dp法で部分和
		int[][] grid = new int[N+1][possibleMax+1];
		for(int i= 1;i<=N;i++) {
			for(int j= nums[i-1];j<=possibleMax;j++) {
				grid[i][j] = Math.max(grid[i-1][j],	 grid[i-1][j-nums[i-1]]	+	nums[i-1]);
//				if(grid[i][j] > possibleMax) {
//					
//				}
			}
		}
		int ans = 0;
		for(int i= 0;i<=possibleMax;i++) {
			ans = Math.max(ans, grid[N][i]);
		}
		
		return total-ans;
	}
}
