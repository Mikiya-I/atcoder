package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner177_SumOfProductOfPairs {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		long[] sums = new long[N+1];
		final long base = (long) (1E9+7);
		long current =0;
		//modの累積和
		for(int i=0;i<N;i++) {
			current = (current +Long.parseLong(strs[i]))%base;
			sums[i+1]=current;
		}

		long ans =0;
		for(int i=1;i<=N;i++) {
			long param1= (sums[i]-sums[i-1]);
			long param2 = (sums[N]-sums[i]+base)%base;
			ans+=(param1 *param2)%base;
			ans %= base;
		}
		System.out.println(ans);
	}

}

