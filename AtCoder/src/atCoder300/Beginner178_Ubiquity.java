package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner178_Ubiquity {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		final int N = Integer.parseInt(reader.readLine());
		long ans = slove(N);
		System.out.println(ans);
	}

		public static long slove(int N) {
			long base = (long)1e9+7;
			if(N==1)
				return 0;

			long ans=1;
			//並べ方の総数(Nの階乗)
			for(int i=1;i<=N;i++) {
				ans*= i;
				ans%=base;
			}

			//要素の数(N-2個の要素の数)
			for(int i=0;i<N-2;i++) {
				ans*=10;
				ans%=base;
			}
			return ans;
		}
}

