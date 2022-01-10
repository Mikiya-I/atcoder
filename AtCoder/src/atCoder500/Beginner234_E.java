package atCoder500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner234_E {
	static long X;
	static String x;

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
		//				slove();
		input();
		System.out.println(slove());
	}

	public static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		x = reader.readLine();
		X = Long.parseLong(x);
		reader.close();
	}

	public static long slove() throws IOException {
		if (X < 10 || isAns(X)) {
			return X;
		}
		long ans = Long.MAX_VALUE;
		//1桁目
		for (int i = 1; i < 10; i++) {
			//公差
			for (int j = -9; j < 10; j++) {
				//追加する数字
				int addDigit = i;
				//現在の値
				long val = 0;
				//X以上になるか等差数の条件を満たさなくなるまで値を足していく
				while (val < X && addDigit <= 9 && addDigit >= 0) {
					val = val * 10 + addDigit;
					addDigit += j;
				}
				if (val >= X) {
					ans = Math.min(ans, val);
				}
			}
		}

		return ans;
	}

	static boolean isAns(long x) {
		long val1 = x % 10;
		x /= 10;
		long val2 = x % 10;
		x /= 10;
		long diff = val1 - val2;
		val1 = val2;

		while (x > 0) {
			val2 = x % 10;
			x /= 10;
			if (val1 - val2 != diff)
				return false;
			val1 = val2;
		}
		return true;
	}

}
