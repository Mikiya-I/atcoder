package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner248_B {
	static long A,B,K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		A = Long.parseLong(strs[0]);
		B = Long.parseLong(strs[1]);
		K = Long.parseLong(strs[2]);
		reader.close();
	}

	public static long slove() throws IOException {
		long ans = 0;
		while(A < B) {
			ans ++;
			A *= K;
		}
		return ans;
	}

}