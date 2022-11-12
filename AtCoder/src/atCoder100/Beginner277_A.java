package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner277_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int x = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(strs[i]);
		for(int i=0;i<n;i++) {
			if(arr[i] == x) {
				System.out.println(i+1);
				return;
			}
		}
	}
	
}
