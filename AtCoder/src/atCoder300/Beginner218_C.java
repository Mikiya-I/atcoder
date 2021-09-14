
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner218_C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//		 slove();
		//		long ans = slove();
		System.out.println(slove());
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		boolean[][] sGrid = new boolean[N][N];
		boolean[][] tGrid = new boolean[N][N];

		int sCnt = 0;
		//幅も取っておく
		int syMin = N;
		int syMax = 0;
		int sxMin = N;
		int sxMax = 0;

		for (int i = 0; i < N; i++) {
			char[] strs = reader.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (strs[j] == '#') {
					sGrid[i][j] = true;
					sCnt++;
					syMin = Math.min(syMin, i);
					syMax = Math.max(syMax, i);
					sxMin = Math.min(sxMin, j);
					sxMax = Math.max(sxMax, j);
				}
			}
		}
		int sWidth = sxMax - sxMin + 1, sHeight = syMax - syMin + 1;

		int tCnt = 0;
		//幅も取っておく
		int tyMin = N;
		int tyMax = 0;
		int txMin = N;
		int txMax = 0;
		for (int i = 0; i < N; i++) {
			char[] strs = reader.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (strs[j] == '#') {
					tGrid[i][j] = true;
					tCnt++;
					tyMin = Math.min(tyMin, i);
					tyMax = Math.max(tyMax, i);
					txMin = Math.min(txMin, j);
					txMax = Math.max(txMax, j);
				}
			}
		}
		//高さと幅
		int tWidth = txMax - txMin + 1, tHeight = tyMax - tyMin + 1;

		if (tCnt != sCnt)
			return "No";
		else if (tCnt < 2 || tCnt == N * N)
			return "Yes";

		//Sの正規化
		boolean[][] nS = normalize(sGrid, sHeight, sWidth, syMin, syMax, sxMin, sxMax);

		//Tの正規化
		boolean[][] nT = normalize(tGrid, tHeight, tWidth, tyMin, tyMax, txMin, txMax);
		
		sGrid = null;
		tGrid = null;

		for (int i = 0; i < 4; i++) {
			if (tHeight == nS.length && tWidth == nS[0].length) {
				boolean ok = true;
				for (int y = 0; y < tHeight; y++) {
					if(!Arrays.equals(nS[y], nT[y])) {
						ok= false;
					}
					if (!ok)
						break;
				}
				if (ok)
					return "Yes";
			}
			nS = rotate(nS);
		}
		return "No";
	}
	
	//回転(右に90度回転)
	private static boolean[][] rotate(boolean[][] grid){
		int originWidth= grid[0].length, originHeight = grid.length;
		boolean[][] result = new boolean[originWidth][originHeight];
		for(int i=0;i<originHeight;i++) {
			for(int j=0;j<originWidth;j++) {
//				result[i][x-1-j] = grid[i][j];
				result[originWidth-1-j][i]= grid[i][j];
			}
		}
		
		return result;
	}
	
	//正規化(図形の一番下と左の座標を0,0にする)
	private static boolean[][] normalize(boolean[][] grid,int height,int width, int yMin,int yMax, int xMin, int xMax){
		boolean[][] result = new boolean[height][width];
		for (int i = yMin; i <= yMax; i++) {
			for (int j = xMin; j <= xMax; j++) {
				result[i-yMin][j-xMin] = grid[i][j];
			}
		}
		return result;
	}
}
