package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner182_To3 {

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

		if(digitsTotal%3 == 1) {
			for(int i=0;i<len;i++) {
				if(arr[i] %3 ==1){
					if(len >1) {
						System.out.println(1);
						return;
					}else {
						System.out.println(-1);
						return;
					}
				}
			}
			if(len <=2) {
				System.out.println(-1);
				return;
			}else {
				System.out.println(2);
				return;
			}
		}

		if(digitsTotal%3 == 2) {
			for(int i=0;i<len;i++) {
				if(arr[i] %3 ==2){
					if(len >1) {
						System.out.println(1);
						return;
					}else {
						System.out.println(-1);
						return;
					}
				}
			}
			if(len ==2) {
				System.out.println(-1);
				return;
			}else {
				System.out.println(2);
				return;
			}
		}

	}

}
