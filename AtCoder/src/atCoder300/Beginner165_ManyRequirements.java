package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner165_ManyRequirements {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner165_ManyRequirements This = new Beginner165_ManyRequirements();
		int ans =This.slove();
		System.out.println(ans);
	}

	public int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		final int Q = Integer.parseInt(strs[2]);

		for(int i=0;i<Q ;i++) {
			String s[] = reader.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			int d = Integer.parseInt(s[3]);
		
		
		
		}
	}
}
