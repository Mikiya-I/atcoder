
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner227_C {
	static long N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
//		slove2();
		//		long ans = slove();

		System.out.println(slove());
	}

	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(reader.readLine());
		reader.close();
	}

	public static long slove() throws IOException {
		long ans =0;
		//Nの3乗根(最小値の最大値)
		long maxA = (long) Math.cbrt(N);
		for(int i=1;i<=maxA;i++) {
			//Bの最大値(N/Aの√)
			long tmp = N/i;
			long maxB = (long) Math.sqrt(tmp);
			for(int j=i;j<=maxB;j++) {
				long add =tmp/j -j+1;
				ans += add;
			}
		}
		
		return ans ;
	}

}