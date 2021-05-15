package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner201_TinyArithmeticSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		String[] strs = reader.readLine().split(" ");
		int length = strs.length;
		int[] nums = new int[length];
		for(int i=0;i<length;i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(nums);
		int distance = nums[1] -nums[0];
		for(int i=1;i<length;i++) {
			if(nums[i]-nums[i-1]!= distance) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

}
