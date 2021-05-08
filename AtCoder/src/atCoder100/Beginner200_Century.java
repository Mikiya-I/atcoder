package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner200_Century {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		int X = Integer.parseInt(reader.readLine());
		int ans = X/100;
		if(X%100!= 0)
			ans ++;
		System.out.println(ans);
	}

}
