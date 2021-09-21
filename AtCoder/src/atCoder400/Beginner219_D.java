package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner219_D {

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
		//		slove();
		System.out.println(slove());
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		final int X = Integer.parseInt(strs[0]);
		final int Y = Integer.parseInt(strs[1]);
		//n番目までの要素でX,Yの個数以上になるための最小値
		int[][][] dp = new int[N+1][X+1][Y+1];
		Arrays.fill(dp,Integer.MAX_VALUE );
		dp[0][0][0] = 0;
		int aSum = 0,bSum = 0;
		for(int i=1;i<=N;i++) {
			strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			aSum += a;
			int b = Integer.parseInt(strs[1]);
			bSum += b;
			dp[i][a][b] = 1;
		}
		if(aSum < X ||bSum < Y) {
			return -1;
		}
		//dp計算
		for(int i =1;i<N;i++) {
			for(int j=0;j<X;j++) {
				for(int k=0;k<Y;k++) {
					
				}
			}
		}
		
		return dp[N][X][Y];
	}
	private static long slove2() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		final int x = Integer.parseInt(strs[0]);
		final int y = Integer.parseInt(strs[1]);
        int[][] dp = new int[x + 1][y + 1];
        int INF = Integer.MAX_VALUE;
        for (int[] is : dp) 
        	Arrays.fill(is, INF);
 
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
        	strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
            for (int j = x; j >= 0; j--) { for (int k = y; k >= 0; k--) {
                int j2 = Math.min(j + a, x);
                int k2 = Math.min(k + b, y);
                dp[j2][k2] = Math.min(dp[j2][k2], 1 + dp[j][k]);
                }
            }
        }
        return dp[x][y]==INF?-1:dp[x][y];
	}
}
