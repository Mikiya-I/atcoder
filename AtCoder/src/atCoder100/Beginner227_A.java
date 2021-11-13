package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner227_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		int A = Integer.parseInt(strs[2]);
		
		int tmp = K%N;
		int ans = (tmp+A-1)%N;
		if(ans ==0)
			ans = N;
		System.out.println(ans);
	}
}
