package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner182_To3_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		reader.close();

		//数字の配列に
		final int len = str.length();
		int[] arr = new int[len];
		int digitsTotal = 0;
		for(int i=0;i<len;i++) {
			int now = Character.getNumericValue(str.charAt(i));
			digitsTotal+= now;
			arr[len-i-1] = now;
		}
		if(digitsTotal < 3) {
			System.out.println(-1);
			return;
		}
		if(digitsTotal%3 ==0) {
			System.out.println(0);
			return;
		}

		int min = len;
		//bit全探索(bitが立っている箇所を削除)
		for(int i= 1;i< 1<<len;i++) {
			int current = Integer.bitCount(i);
			int currentDigitsTotal = 0;
			//最小値を更新し得ないならスキップ
			if(min <= current) continue;

			for(int j = 0;j<len;j++) {
				//bitが立っていない箇所の合計
				if((i>>j&1)==0) {
					currentDigitsTotal += arr[j];
				}
			}

			if(currentDigitsTotal != 0&&currentDigitsTotal %3 ==0) min= current;

		}

		System.out.println(min==len?-1:min);
	}

}
