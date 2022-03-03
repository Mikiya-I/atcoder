
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner241_C {
	static int N;
	static boolean[][] grid;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		grid = new boolean[N][N];
		for(int i=0;i<N;i++) {
			char[] arr = reader.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				if(arr[j] == '#')
					grid[i][j] = true;
			}
		}
		
		reader.close();
	}

	public static String slove() throws IOException {
		int[][] g = new int[N][];
		for(int i=0;i<N;i++) {
			int[] a = new int[N];
			Arrays.fill(a, -1);
			g[i] = a;
		}
		//↓6個連続させるために必要な変換数
		//横方向
		int[][] dpX = g.clone();
		//縦
		int[][] dpY = g.clone();
		//↙方向
		int[][] dpXY = g.clone();
		//↘方向
		int[][] dpYX = g.clone();
		
		//横方向
		for(int i=0;i<N;i++) {
			int needCnt = 0;
			for(int j=0;j<6;j++) {
				if(!grid[i][j]) {
					needCnt ++;
				}
			}
			if(needCnt <= 2)
				return "Yes";
			dpX[i][0] = needCnt;
		}
		
		//縦方向
		for(int j=0;j<N;j++) {
			int needCnt = 0;
			for(int i=0;i<6;i++) {
				if(!grid[i][j]) {
					needCnt ++;
				}
			}
			if(needCnt <= 2)
				return "Yes";
			dpY[0][j] = needCnt;
		}
		
		//↙方向
		for(int j=5;j<N;j++) {
			int needCnt = 0;
			for(int i=0;i<6;i++) {
				if(!grid[i][j-i]) {
					needCnt ++;
				}
			}
			if(needCnt <= 2)
				return "Yes";
			dpXY[0][j] = needCnt;
		}
		
		// \方向
		for(int j=0;j<N-5;j++) {
			int needCnt = 0;
			for(int i=0;i<6;i++) {
				if(!grid[i][j+i]) {
					needCnt ++;
				}
			}
			if(needCnt <= 2)
				return "Yes";
			dpYX[0][j] = needCnt;
		}
		
		//横のdp
		for(int i=0;i<N;i++) {
			for(int j=1;j<N-6;j++) {
				int tmp = dpX[i][j-1];
				if(!grid[i][j-1])
					tmp --;
				if(!grid[i][j+5])
					tmp ++;
				if(tmp <= 2) {
					return "Yes";
				}else {
					dpX[i][j] = tmp;
				}
			}
		}
		
		//縦のdp
		for(int i=1;i<N-5;i++) {
			for(int j=0;j<N;j++) {
				int tmp = dpX[i-1][j];
				if(!grid[i-1][j])
					tmp --;
				if(!grid[i+5][j])
					tmp ++;
				if(tmp <= 2) {
					return "Yes";
				}else {
					dpY[i][j] = tmp;
				}
			}
		}
		
		//↙方向
		for(int i=1;i<N-5;i++) {
			for(int j=5;j<N;j++) {
				//新しく計算
				if(j==N-1) {
					int needCnt = 0;
					for(int k=0;k<6;k++) {
						if(!grid[i+k][j-k]) {
							needCnt ++;
						}
					}
					if(needCnt <= 2)
						return "Yes";
					dpXY[i][j] = needCnt;
				}else {
					int tmp = dpX[i-1][j-1];
					if(!grid[i-1][j+1])
						tmp --;
					if(!grid[i+5][j-5])
						tmp ++;
					if(tmp <= 2) {
						return "Yes";
					}else {
						dpXY[i][j] = tmp;
					}
				}
			}
		}
		
		//↘方向
		for(int i=1;i<N-5;i++) {
			for(int j=0;j<N-5;j++) {
				//新しく計算
				if(j==0) {
					int needCnt = 0;
					for(int k=0;k<6;k++) {
						if(!grid[i+k][j+k]) {
							needCnt ++;
						}
					}if(needCnt <= 2)
						return "Yes";
					dpYX[i][j] = needCnt;
				}else {
					int tmp = dpX[i-1][j-1];
					if(!grid[i-1][j-1])
						tmp --;
					if(!grid[i+5][j+5])
						tmp ++;
					if(tmp <= 2) {
						return "Yes";
					}else {
						dpYX[i][j] = tmp;
					}
				}
			}
		}
		
		return "No";
	}
	
}