package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner199_SquareInequality {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		String[] strs = reader.readLine().split(" ");
		int A = Integer.parseInt(strs[0]);
		int B = Integer.parseInt(strs[1]);
		int C = Integer.parseInt(strs[2]);
		System.out.println(A*A+B*B<C*C?"Yes":"No");
	}

}
