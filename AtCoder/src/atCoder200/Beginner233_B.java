package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner233_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 slove();
//		System.out.println(slove());
	}

	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int l = Integer.parseInt(strs[0]);
		int r = Integer.parseInt(strs[1]);
		char[] s = reader.readLine().toCharArray();
		for(int i=l-1,j=r-1;i<j;i++,j--) {
			char tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
		}
		
		System.out.println(new String(s));
	}
}
