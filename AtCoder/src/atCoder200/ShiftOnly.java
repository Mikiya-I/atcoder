package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShiftOnly {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strs = reader.readLine();
		int n = (Integer.parseInt(strs)) - 1;

		//配列として扱う場合
		String[] strs2 = reader.readLine().split(" ");
		int[] aaa = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			aaa[i] = Integer.parseInt(strs2[i]);
		}

		boolean canDevide = true;
		int result = 0;
		while (canDevide) {
			for (int j = 0; j < aaa.length; j++) {
				if (aaa[j] % 2 == 0) {
					aaa[j] = aaa[j] / 2;
				} else {
					canDevide = false;
				}
			}
			if (canDevide == true) {
				result++;
			}
		}
		System.out.println(result);
	}
}
