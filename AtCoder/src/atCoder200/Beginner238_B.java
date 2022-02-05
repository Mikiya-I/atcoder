package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner238_B {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		arr = new int[N+1];
		String[] strs = reader.readLine().split(" ");
		int tmpDeg = 0;
		for(int i = 0;i<N ;i++) {
			tmpDeg += Integer.parseInt(strs[i]);
			tmpDeg %= 360;
			arr[i+1] = tmpDeg;
			
		}
		reader.close();
	}

	public static int slove() throws IOException {
		int ans = 0;
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			ans = Math.max(ans, arr[i+1] - arr[i] );
		}
		ans = Math.max(ans, 360 -arr[N]);
		return ans;
	}
	
}
 