package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner078_C {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long  ans = slove();
		System.out.println(ans);
	}

	
    public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ") ;
		final int  N = Integer.parseInt(strs[0]);
		final int M =  Integer.parseInt(strs[1]);
		
		int  expectdValue = (int) Math.pow(2, M);
		long  ans = expectdValue *( (N-M) *100 + M*1900);
		
		return ans;
    }
}
