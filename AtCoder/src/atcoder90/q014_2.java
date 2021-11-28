package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q014_2 {

	static int N;
	static int[] A,B;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//	static List<HashSet<Integer>> path;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
	}
	
	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		String[] strs2 = reader.readLine().split(" ");
		reader.close();
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(strs[i]);
			B[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(A);
		Arrays.sort(B);
	}

	static long slove() throws IOException {
		return 0;
    }
	
}