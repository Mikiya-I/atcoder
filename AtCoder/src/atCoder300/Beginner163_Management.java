package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner163_Management {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		String ans = slove();
		System.out.println(ans);
	}
 
	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());

		String[] strs = reader.readLine().split(" ");
		int[] member = new int [N];
		for(int i=0;i<N-1;i++) {
			member[Integer.parseInt(strs[i])-1]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int tmp : member) {
			sb.append(tmp + "\n");
		}
		return sb.toString();
	}
}
