package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Beginner252_B {
	static int N,K;
	static int[] A;
	static HashSet<Integer> B;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		A = new int[N];
		B = new HashSet<Integer>();
		for(int i=0;i<N;i++)
			A[i] = Integer.parseInt(strs[i]);
		strs = reader.readLine().split(" ");
		for(int i=0;i<K;i++)
			B.add(Integer.parseInt(strs[i]));
		
		reader.close();
	}

	public static String slove() throws IOException {
		int[] arr= A.clone();
		Arrays.sort(arr);
		int max = arr[N-1];
		HashSet<Integer> idx = new HashSet<Integer>();
		for(int i=0;i<N;i++) {
			if(A[i] == max)
				idx.add(i);
		}
		for(int i : idx) {
			if(B.contains(i+1))
				return "Yes";
		}
		
		return "No";
	}

}