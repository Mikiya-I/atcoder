package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner236_B {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		arr = new int[N+1];
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<N*4 -1 ;i++) {
			arr[Integer.parseInt(strs[i])] ++;
		}
		reader.close();
	}

	public static int slove() throws IOException {
		for(int i=1;i<=N;i++) {
			if(arr[i] == 3)
				return i;
		}
		
		return -1;
	}
	
}
