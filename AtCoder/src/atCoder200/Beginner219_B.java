package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner219_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = new String[3];
		for(int i=0;i<3; i++) {
			strs[i] = reader.readLine();
		}
		char[] arr = reader.readLine().toCharArray();
		for(char c : arr) {
				sb.append(strs[ (int) c -49]);
		}
		
		return sb.toString();
	}
}
