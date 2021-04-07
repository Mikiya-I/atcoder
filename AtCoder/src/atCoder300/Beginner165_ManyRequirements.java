package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner165_ManyRequirements {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner165_ManyRequirements This = new Beginner165_ManyRequirements();
		long ans =This.slove();
		System.out.println(ans);
	}

	public long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		final int Q = Integer.parseInt(strs[2]);

		int[] A = new int[Q];
		int[] B = new int[Q];
		int[] C = new int[Q];
		int[] D = new int[Q];
		for(int i=0;i<Q ;i++) {
			String s[] = reader.readLine().split(" ");
			A[i] = Integer.parseInt(s[0]);
			B[i] = Integer.parseInt(s[1]);
			C[i] = Integer.parseInt(s[2]);
			D[i] = Integer.parseInt(s[3]);
		}
		long ans =0;
		int array[] = new int[N];
		int n=N;


		return ans;
	}
}
