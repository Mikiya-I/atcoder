package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner117_Streamline {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(slove());
		
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		//NがM以上なら0手で行ける　
		if(N>=M)
			return 0;
		String[] nums = reader.readLine().split(" ");
		reader.close();
		int[] points = new int[M];
		for (int i = 0; i <M; i++) {
			points[i] = Integer.parseInt(nums[i])+20000;
		}
		Arrays.sort(points);
		int[] distances = new int[M-1];
		for(int i=0;i<M-1;i++) {
			distances[i] = points[i+1]-points[i];
		}
		Arrays.sort(distances);
		int ans = points[M-1]-points[0];
		for(int i=1;i<N;i++) {
			ans-= distances[M-i-1];
		}
		
		return ans;
	}
}
