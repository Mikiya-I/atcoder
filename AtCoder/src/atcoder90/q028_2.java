package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q028_2 {

	static int N;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] grid = new int[1001][1001];
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
	}
	
	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(reader.readLine());
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			int lx = Integer.parseInt(strs[0]);
			int ly = Integer.parseInt(strs[1]);
			int rx = Integer.parseInt(strs[2]);
			int ry = Integer.parseInt(strs[3]);
			grid[ly][lx] ++;
			grid[ly][rx]--;
			grid[ry][lx]--;
			grid[ry][rx]++;
		}
	}

	static String slove() throws IOException {
		int[] cnt = new int[N+1];
		//横方向のいもす法
		for(int i=0;i<grid.length;i++) {
			for(int j = 1;j<grid[i].length;j++) {
				grid[i][j]+= grid[i][j-1];
			}
		}
		//縦方向のいもす法
		for(int i=1;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j] += grid[i-1][j];
			}
		}
		
		for(int[] arr:grid) {
			for(int i:arr) {
				cnt[i]++;
			}
		}
		for(int i=1;i<cnt.length;i++) {
			sb.append(cnt[i] + "\n");
		}
		return sb.toString();
    }
}