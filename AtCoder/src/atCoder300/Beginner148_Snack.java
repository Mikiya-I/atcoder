package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner148_Snack {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		String[] strs = reader.readLine().split(" ");
		reader.close();

		final int A = Integer.parseInt(strs[0]);
		final int B = Integer.parseInt(strs[1]);
		int max = Math.max(A, B);
		int min = Math.min(A, B);
		int mod = max%min;
		long ans = (long)A*(long)B;

		//ユークリッドの互除法
		while(mod >1) {
			max= min;
			min = mod;
			mod = max %min;
		}

		if(mod==0)
			ans /=min;

		System.out.println(ans);
	}
}