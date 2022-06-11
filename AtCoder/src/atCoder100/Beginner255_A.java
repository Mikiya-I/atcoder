package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner255_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[][] grid = new int[2][2];
		String[] strs = reader.readLine().split(" ");
		int R = Integer.parseInt(strs[0]);
		int C = Integer.parseInt(strs[1]);
		for(int i=0;i<2;i++) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<2;j++) {
				grid[i][j] = Integer.parseInt(strs[j]);
			}
		}
		System.out.println(grid[R-1][C-1]);
	}
	
}
