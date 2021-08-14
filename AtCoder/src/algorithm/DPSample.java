package algorithm;

public class DPSample {
	//要素数
	int N;
	//値
	int M;
	//数列(サイズはN)
	int nums[];
	
	//サンプルとしてある特定の値以下の値の最大値
	int dpSum() {
		int[][] grid = new int[N][M+1];
		for(int i= 1;i<=N;i++) {
			for(int j= nums[i-1];j<=M;j++) {
				grid[i][j] = Math.max(grid[i-1][j],	 grid[i-1][j-nums[i-1]]	+	nums[i-1]);
			}
		}
		for(int i=M;i>=0;i--) {
			if(grid[N][i] != 0) {
				return grid[N][i];
			}
		}
		//見つからなければ0
		return 0;
	}
	
}
