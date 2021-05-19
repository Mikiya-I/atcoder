package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner088_C {

	public static void main(String[] args) throws NumberFormatException, IOException {

		String  ans = slove();
		System.out.println(ans);
	}

	
    public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[][] grid = new int [3][3];
		for (int i=0;i<3;i++) {
			String[] strs = reader.readLine().split(" ");
			for(int j=0;j<3;j++) {
				grid[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		for(int i= 1;i<3;i++) {
			int base = grid[i][0] -grid[i-1][0];
			for(int j=0;j<3;j++) {
				if(grid[i][j]-grid[i-1][j] != base){
					return "No";
				}
			}
		}
		
		return "Yes";
    }
}
