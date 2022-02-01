
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner237_C {
	static int N;
	static char[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		arr = reader.readLine().toCharArray();
		reader.close();
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			if(t.contains(s[i])) {
				sb.append("Yes");
			}else {
				sb.append("No");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	

}