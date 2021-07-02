package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner159_D {
	public static void main(String[] args) throws IOException {
//		slove();
		String  ans = slove();
		System.out.println(ans);
	}
	
	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		reader.close();
		int[] arr = new int[N];
		long[] nums = new long[(int) (2e5+1)];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(strs[i]);
			nums[arr[i]]++;
		}
		
		long total =0;
		for(long i:nums) {
			total += i*(i-1)/2;
		}
		StringBuilder sb = new StringBuilder();
		for(int i:arr) {
			long tmp = total-nums[i]*(nums[i]-1)/2+( nums[i]-1)*(nums[i]-2)/2;
			sb.append(tmp);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
