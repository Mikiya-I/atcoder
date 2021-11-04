package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class q063 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static int slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		final int H = Integer.parseInt(strs[0]);
		final int W = Integer.parseInt(strs[1]);
		int[][] grid = new int[H][W];
		for(int i=0;i<H;i++) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<W;j++) {
				grid[i][j] = Integer.parseInt(strs[j]);
			}
		}
		reader.close();
		
		int ans = 1;
		int loop= 1<<H;
		//ここから
		for(int i=1;i<loop;i++) {
			//xの列が何個あるか
			Map<Integer,Integer> map = new HashMap<Integer, Integer>();
			for(int column = 0;column <W;column++) {
				int num =0;
				boolean ok = true;
				for(int row = 0;row<H;row++) {
					if ((i >> row & 1) == 1) {
						if (num == 0) {
							num = grid[row][column];
						} else if (num != grid[row][column]) {
							ok = false;
							break;
						}
					}
				}
				if(ok) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				}
			}
			int max =0;
			for(int n:map.values())
				max = Math.max(max, n);
			//何行選択しているか
			int rows = Integer.bitCount(i);
			ans = Math.max(ans,max*rows);
		}
		
		return ans;
	}
}
