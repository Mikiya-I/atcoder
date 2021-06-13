package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner205_B {


	public static void main(String[] args) throws NumberFormatException, IOException {

		String ans =slove();
		System.out.println(ans);
	}

	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int  N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		boolean[] arr = new boolean[N+1];
		arr[0] = true;
		for(int i=0;i<N;i++) {
			arr[Integer.parseInt(strs[i])] = true;
		}
		for(boolean tmp : arr) {
			if(!tmp) {
				return "No";
			}
		}
		return "Yes";
	}
}
