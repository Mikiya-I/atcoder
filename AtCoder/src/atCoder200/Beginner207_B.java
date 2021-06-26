package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner207_B {


	public static void main(String[] args) throws NumberFormatException, IOException {

		long  ans =slove();
		System.out.println(ans);
	}

	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = reader.readLine().split(" ");
		final long  A = Integer.parseInt(strs[0]);
		final long  B = Integer.parseInt(strs[1]);
		final long C = Integer.parseInt(strs[2]);
		final long  D = Integer.parseInt(strs[3]);
		
		if(B>=C*D ) {
			return -1;
		}
		int i=1;
		while(D*i*C <(A+i*B)) {
			i++;
		}
		return i;
	}
}
