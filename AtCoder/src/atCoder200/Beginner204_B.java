package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner204_B {


	public static void main(String[] args) throws NumberFormatException, IOException {

		int ans =slove();
		System.out.println(ans);
	}

	public static int  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int  N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		int ans =0;
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(strs[i]);
			if(tmp>10) {
				ans+=tmp-10;
			}
		}
		return ans;
	}
}
