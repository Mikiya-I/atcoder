package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q084_2 {
	static int N;
	static boolean[] arr;
	public static void main(String[] args) throws IOException {
		input();
//		test();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		char[] s = reader.readLine().toCharArray();
		arr = new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i] = s[i]=='o';
		}
		reader.close();
	}
	
	public static long slove() throws  IOException {
		
		
		return 0;
	}
	
}
