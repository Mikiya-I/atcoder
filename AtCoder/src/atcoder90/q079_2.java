package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q079_2 {
	static int H,W;
	static int[][] A,B;
	static int[] xDiff = {0,1,0,1};
	static int[] yDiff = {0,0,1,1};
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		H = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
		A = new int[H][W];
		B = new int[H][W];
		for(int i=0;i<H;i++) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<W;j++) {
				A[i][j] = Integer.parseInt(strs[j]);
			}
		}
		for(int i=0;i<H;i++) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<W;j++) {
				B[i][j] = Integer.parseInt(strs[j]);
			}
		}
		reader.close();
	}
	
	public static String slove() throws  IOException {
		long total = 0;;
		//左上からそろえていく
		for(int i=0;i<H-1;i++) {
			for(int j=0;j<W-1;j++) {
				int tmpDiff = A[i] [j] - B[i] [j];
				for(int k=0;k<4;k++) {
					A[i + yDiff[k]] [j + xDiff[k]]  -= tmpDiff;
				}
				total += Math.abs(tmpDiff);
			}
		}
		for(int i=0;i<H;i++) {
			if(A[i][W-1] != B[i][W-1])
				return "No";
		}
		
		for(int j=0;j<W;j++) {
			if(A[H-1][j] != B[H-1][j])
				return "No";
		}
		
		return "Yes\n" + String.valueOf(total);
	}
	
}
