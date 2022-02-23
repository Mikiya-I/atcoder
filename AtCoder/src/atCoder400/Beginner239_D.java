package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner239_D {
	static int N,Q;
	static int[] X,V,K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		Q = Integer.parseInt(strs[1]);
		X = new int[N];
		strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			X[i] = Integer.parseInt(strs[i]);
		}
		reader.close();
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}

}