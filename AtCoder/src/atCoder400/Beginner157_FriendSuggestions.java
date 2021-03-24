package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner157_FriendSuggestions {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		final int K = Integer.parseInt(strs[2]);

		int[] arr= slove(N,M,K);
		StringBuilder sb = new StringBuilder();
		for(int i:arr)
			sb.append(i+" ");
		System.out.println(sb.toString());
	}

	static int[] slove(int N,int M,int K) {
		int[] arr=new int[] {};
		return arr;
	}
}