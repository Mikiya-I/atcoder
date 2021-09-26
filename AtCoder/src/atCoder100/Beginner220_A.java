package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner220_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int A = Integer.parseInt(strs[0]);
		final int B = Integer.parseInt(strs[1]);
		final int C = Integer.parseInt(strs[2]);
		
		int tmp = B/C;
		int ans = tmp*C;
		if(A<=ans)
			System.out.println(ans);
		else
			System.out.println(-1);
		
	}
}
