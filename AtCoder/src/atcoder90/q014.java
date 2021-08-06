package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q014 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		int[] students = new int[N];
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			students[i] = Integer.parseInt(strs[i]);
		}
		
		strs=reader.readLine().split(" ");
		reader.close();
		int schools[] = new int [N];
		for(int i=0;i<N;i++) {
			schools[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(students);
		Arrays.sort(schools);
		long ans =0;
		//貪欲法で小さいものから選んでいく
		for(int i=0;i<N;i++) {
			ans += (long)Math.abs(students[i] - schools[i]);
		}
		
		
		return ans;
	}
}
