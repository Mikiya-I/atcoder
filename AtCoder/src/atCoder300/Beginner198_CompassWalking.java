package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner198_CompassWalking {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long ans =slove();
		System.out.println(ans);
	}

	public static long slove() throws IOException {
		long ans;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		reader.close();
		final long R = Integer.parseInt(strs[0]);
		final long X = Integer.parseInt(strs[1]);
		final long Y = Integer.parseInt(strs[2]);
		
		
		final double distance = Math.ceil(Math.sqrt(Math.pow(X, 2)+Math.pow(Y, 2)));
		if(distance % R == 0)
			ans = (long) (distance / R);
		else {
			if(R > distance)
				ans = 2;
			else
				ans = (long) Math.ceil(distance/R );
		}
		return ans;
	}
//	public static BigDecimal slove() throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String[] strs = reader.readLine().split(" ");
//		reader.close();
//		BigDecimal R= new BigDecimal(strs[0]);
//		BigDecimal X = new BigDecimal(strs[1]);
//		BigDecimal Y = new BigDecimal(strs[1]);
//		
//		BigDecimal param =X.pow(2).add(Y.pow(2));
//		BigDecimal distance = param.sqrt(null);
//		BigDecimal ans;
//		if(distance.remainder(R).equals(new BigDecimal("0")))
//			ans = distance.divide(R);
//		else
//			ans = distance.divide(R).add(new BigDecimal("1"));
//		
//		return ans;
//	}
	
}
