package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner195_HealthMDeath {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		String[] str = reader.readLine().split(" ");
		final int M = Integer.parseInt(str[0]);
		final int H = Integer.parseInt(str[1]);

		String ans;
		if(H%M==0) {
			ans = "Yes";
		}else
			ans ="No";

		System.out.println(ans);
	}

}
