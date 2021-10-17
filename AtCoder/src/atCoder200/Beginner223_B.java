package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner223_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 slove();
//		System.out.println(slove());
	}

	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		char[] arr = str.toCharArray();
		char[] alphaCnt = str.toCharArray();
		Arrays.sort(alphaCnt);
		char minChar = alphaCnt[0];
		char maxChar = alphaCnt[alphaCnt.length-1];
		String[] strs = new String[str.length()];
		for(int i=0;i<strs.length;i++) {
			char[] tmp = new char[str.length()];
			int idx = 0;
			for(int j=i;j<strs.length;j++,idx++) {
				tmp[idx] = arr[j];
			}
			for(int j= 0;j<i;j++,idx++) {
				tmp[idx] = arr[j];
			}
			strs[i] = new String(tmp);
		}
		
		Arrays.sort(strs);
		System.out.println(strs[0]);
		System.out.println(strs[strs.length-1]);
		
//		return "";
	}
}
