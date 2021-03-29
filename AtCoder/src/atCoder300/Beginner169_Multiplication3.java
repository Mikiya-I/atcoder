package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Beginner169_Multiplication3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner169_Multiplication3 This = new Beginner169_Multiplication3();
		long ans =This.slove();
		System.out.println(ans);
	}

	public long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		reader.close();
//		final long A = Long.parseLong(strs[0]);
//		final double B = Double.parseDouble(strs[1])*100;
//		double ans = (double)A * B;
//		ans /= 100;
//		return (long)ans;
		BigDecimal A = new BigDecimal(strs[0]);
		BigDecimal B = new BigDecimal(strs[1]);
		BigDecimal ans = A.multiply(B);
		long x = ans.longValue();
		return x;
	}
}
