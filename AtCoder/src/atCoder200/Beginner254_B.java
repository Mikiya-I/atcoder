package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner254_B {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		reader.close();
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		int[][] grid = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				grid[i][0]= 1;
				grid[i][j]=1;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=1;j<i;j++) {
				grid[i][j] = grid[i-1][j-1]+grid[i-1][j];
			}
		}
				
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				sb.append(grid[i][j]+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}