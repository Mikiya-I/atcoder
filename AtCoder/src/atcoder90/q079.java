package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q079 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int H = Integer.parseInt(strs[0]);
		final int W = Integer.parseInt(strs[1]);
		
		int[][] A = new int[H][W];
		int[][] B = new int[H][W];
		int[][] difference = new int[H][W];

		for(int i=0;i<H;i++) {
			strs = reader.readLine().split(" ");
			for(int j= 0;j<W;j++) {
				A[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		for(int i=0;i<H;i++) {
			strs = reader.readLine().split(" ");
			for(int j= 0;j<W;j++) {
				B[i][j] = Integer.parseInt(strs[j]);
				difference[i][j] = A[i][j]-B[i][j];
			}
		}
		
		long cnt = 0;
		//判定
		for(int i=0;i<H-1;i++) {
			for(int j=0;j<W-1;j++) {
				int tmp = difference[i][j];
				if(difference[i][j] > 0 ) {
					difference[i][j] -= tmp;
					difference[i+1][j] -= tmp;
					difference[i][j+1] -= tmp;
					difference[i+1][j+1] -= tmp;
					cnt += tmp;
				}else if(difference[i][j] < 0 ) {
					
					difference[i][j] -= tmp;
					difference[i+1][j] -= tmp;
					difference[i][j+1] -= tmp;
					difference[i+1][j+1] -= tmp;
					cnt -= tmp;
				}
			}
		}
		
		for(int i=0;i<H;i++) {
			for(int j= 0;j<W;j++) {
				if(difference[i][j] != 0)
					return "No";
			}
		}
		
		
		return "Yes \n"+cnt;
	}
	
}
