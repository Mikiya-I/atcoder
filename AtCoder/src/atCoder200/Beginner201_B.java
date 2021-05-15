package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Beginner201_B {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner201_B This = new Beginner201_B();
		String ans =This.slove();
		System.out.println(ans);
	}

	public String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		int[] heights = new int[N];
		for(int i= 0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			int tmp = Integer.parseInt(strs[1]);
			map.put(tmp, strs[0]);
			heights[i] = tmp;
		}
		Arrays.sort(heights);
		
		return map.get(heights[N-2]);
	}
}
