package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Beginner213_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static int  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		int[] arr = new int[N];
		HashMap<Integer, Integer>  map = new HashMap<>();
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(strs[i]);
			map.put(arr[i], i+1);
		}
		Arrays.sort(arr);
		
		return map.get(arr[N-2]);
	}
}
