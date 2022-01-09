
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner234_C {
	static long K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		K = Long.parseLong(reader.readLine());
		reader.close();
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		while(K>0) {
			if((K&1) == 1) {
				sb.append(2);
			}else {
				sb.append(0);
			}
			K/= 2;
		}
		
		return sb.reverse().toString();
	}
	
	

}