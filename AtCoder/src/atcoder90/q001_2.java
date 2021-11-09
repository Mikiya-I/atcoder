package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q001_2 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int L = Integer.parseInt(strs[1]);
		final int K = Integer.parseInt(reader.readLine());
		strs = reader.readLine().split(" ");
		reader.close();
		int[] eachLength = new int[N];
		for(int i=0;i<N;i++)
			eachLength[i] = Integer.parseInt(strs[i]);
		
		return 0;
	}
}
