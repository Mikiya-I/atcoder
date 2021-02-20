package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner192_uNrEaDaBlEsTrInG {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();

		char[] C = str.toCharArray();
		for(int i= 0,length = C.length;i<length;i++) {
			if(i%2==0) {
				//小文字以外ならout
				if((int)C[i] < 97) {
					System.out.println("No");
					return;
				}
			}else {
				//大文字以外ならアウト
				if((int)C[i] > 90) {
					System.out.println("No");
					return;
				}
			}
		}
		System.out.println("Yes");
	}

}
