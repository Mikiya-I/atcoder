package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner218_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		int[] arr = new int[strs.length];
		for(int i=0;i<strs.length;i++){
			arr[i] = Integer.parseInt(strs[i]);
		}
		for(int i:arr) {
			char c = (char) ('a'+i-1);
			sb.append(c);
		}
		
		return sb.toString();
	}
}
