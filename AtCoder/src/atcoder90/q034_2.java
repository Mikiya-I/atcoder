package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q034_2 {

	static int N,K;
	static int[] arr;
	static boolean[][] bad;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		reader.close();
	}

	static int slove() throws IOException {
		
		return 0;
    }
	
	
}