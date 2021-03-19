package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner177_SumOfProductOfPairs {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		long[] sums = new long[N];
		long[] arr = new long[N];
		final long base = (long) (1E9+7);
		long current =0;
		//modの累積和
		for(int i=0;i<N;i++) {
			long now = Long.parseLong(strs[i]);
			arr[i] = now;
			current = (current+now)%base;
			sums[i]=current;
		}

		long ans =0;
		for(int i=N-1;i>=1;i--) {
			ans+=sums[i-1] *arr[i]%base;
			ans %= base;
		}
		System.out.println(ans);
	}

}

