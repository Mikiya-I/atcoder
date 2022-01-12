package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class q063_2 {
	
	static int[][] grid;
	static int H,W;
	public static void main(String[] args) throws IOException {
//		slove();
		input();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		H = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
		grid = new int[H][W];
		for(int i=0;i<H;i++) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<W;j++) {
				grid[i][j] = Integer.parseInt(strs[j]);
			}
		}
		reader.close();
	}
	
	public static long slove() throws  IOException {
		long ans = 1;
		int bitPattern = 1<<H;
		for(int i=1;i<bitPattern;i++) {
			long tmpCnt = 0;
			int rows = 0;
			boolean[] flag = new boolean[H];
			//桁分の繰り返し
	    	for(int j=0;j<H;j++) {
	    		//ビットが立っている場所を特定
	    		if(((i>>j) & 1)==1)  {
	    			flag[j] = true; 
	    			rows++;
	    		}
	    	}
	    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	    	for(int w = 0;w<W;w++) {
	    		int firstNum = 0;
	    		boolean ok = true;
	    		for(int h = 0;h<H;h++) {
	    			if(flag[h] && firstNum != grid[h][w]) {
	    				if(firstNum==0) {
	    					firstNum = grid[h][w];
	    				}else {
	    					ok = false;
	    					break;
	    				}
	    			}
	    		}
	    		if(!ok)
	    			continue;
	    		if(!map.containsKey(firstNum)) {
	    			map.put(firstNum, 0);
	    		}
	    		int tmp = map.get(firstNum)+rows;
	    		tmpCnt = Math.max(tmpCnt, tmp);
	    		map.replace(firstNum, tmp);
	    	}
	    	ans = Math.max(ans, tmpCnt);
		}
		return ans;
	}
	
}
