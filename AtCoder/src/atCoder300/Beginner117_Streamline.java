package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner117_Streamline {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(slove());
		
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		if(N>=M)
			return 0;
		String[] nums = reader.readLine().split(" ");
		reader.close();
		boolean[] goal = new boolean[20001 ];
		for (int i = 0; i <M; i++) {
			goal[Integer.parseInt(nums[i])+10000] = true;
		}
		
		
		return 1;
	}
}
