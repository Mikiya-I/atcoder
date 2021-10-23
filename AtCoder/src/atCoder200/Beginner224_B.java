package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner224_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 slove();
//		System.out.println(slove());
	}

	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int h = Integer.parseInt(strs[0]);
		final int w = Integer.parseInt(strs[1]);
		long[][] grid = new long[h][w];
		
		for(int i=0;i<h;i++) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<w;j++) {
				grid[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		for(int i=0;i<h-1;i++) {
			for(int i2 = i+1;i2<h;i2++) {
				for(int j=0;j<w-1;j++) {
					for(int j2 = j+1;j2<w;j2++) {
						long a1 = grid[i][j];
						long a2 = grid[i2][j2];
						long a3 = grid[i2][j];
						long a4 = grid[i][j2];
						if(a1+a2 > a3+a4) {
							System.out.println("No");
							return;
						}
					}
				}
			}
		}
		System.out.println("Yes");
		
	}
}
