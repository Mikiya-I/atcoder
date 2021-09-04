package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner217_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = {"ARC" ,"AGC","AHC", "ABC"};
		boolean[] find = new boolean[4];
		for(int i=0;i<3;i++) {
			String s = reader.readLine();
			for(int j=0;j<4;j++) {
				if(str[j].equals(s)) {
					find[j] =true;
				}
			}
		}
		for(int i=0;i<4;i++) {
			if(!find[i]) {
				return str[i];
			}
		}
		return "";
	}
}
