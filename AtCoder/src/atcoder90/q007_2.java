package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q007_2 {

	static int[] arr,B;
	static int N,Q;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		 

	}
	
	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		arr = new int[N];
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(arr);
		Q = Integer.parseInt(reader.readLine());
		B = new int[Q];
		for(int i=0;i<Q;i++)
			B[i] = Integer.parseInt(reader.readLine());
		reader.close();
	}

	static String slove() {
		StringBuilder sb = new StringBuilder();
		//二分探索で一番近い値を求める
		
		return sb.toString();
	}
}
