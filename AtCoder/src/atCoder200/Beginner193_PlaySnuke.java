package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner193_PlaySnuke {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int  N = Integer.parseInt(reader.readLine());

		int ans = Integer.MAX_VALUE;
		for(int i = 0;i<N;i++) {
			String[] str = reader.readLine().split(" ");
			int  A = Integer.parseInt(str[0]);
			int P = Integer.parseInt(str[1]);
			int X = Integer.parseInt(str[2]);
			if(X> A && P < ans)
				ans = P;
		}

		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}

}
