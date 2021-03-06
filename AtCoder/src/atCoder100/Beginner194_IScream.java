package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner194_IScream {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		String[] str = reader.readLine().split(" ");
		final int A = Integer.parseInt(str[0]);
		final int B = Integer.parseInt(str[1]);

		int ans;
		if(A+B >=15 && B>=8)
			ans =1;
		else if(A+B >= 10 && B>=3)
			ans =2;
		else if(A+B >=3)
			ans = 3;
		else
			ans =4;

		System.out.println(ans);
	}

}
