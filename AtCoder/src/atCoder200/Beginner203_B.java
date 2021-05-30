package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner203_B {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int ans =slove();
		System.out.println(ans);
	}

	public static  int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int K = Integer.parseInt(strs[1]);
		
		int ans =0;
		for(int i=1;i<=N;i++) {
			ans += i*100*K;
			ans += (1+K)*K/2;
		}
		
		return ans;
	}
}
