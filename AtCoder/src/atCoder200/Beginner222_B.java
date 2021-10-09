package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner222_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int P = Integer.parseInt(strs[1]);
		
		strs = reader.readLine().split(" ");
		reader.close();
		int ans =0;
		for(int i=0;i<N;i++) {
			if(Integer.parseInt(strs[i]) < P)
				ans++;
		}
		return ans;
	}
}
