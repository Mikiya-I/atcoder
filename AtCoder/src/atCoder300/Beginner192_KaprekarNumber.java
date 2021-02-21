package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner192_KaprekarNumber {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		String[] strs = reader.readLine().split(" ");

		char[] N = strs[0].toCharArray();
		final int K = Integer.parseInt(strs[1]);

		int ans=Integer.parseInt(strs[0]);
		for(int i= 0;i<K;i++) {
			char[] current = N.clone();
			//小さい順に並び変えた数値
			Arrays.sort(current);
			int min = Integer.parseInt(String.valueOf(current));
			//大きい順
			int max = Integer.parseInt(new StringBuilder(String.valueOf(current)).reverse().toString());
			ans = max -min;
			N = Integer.toString(ans).toCharArray();
		}
		System.out.println(ans);
	}
}
