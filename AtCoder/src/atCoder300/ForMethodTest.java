package atCoder300;

import java.util.Random;

public class ForMethodTest {
	static int n;
	static char[][][] originGrid;

	public static void main(String[] args) {
		
		try {
			label:for(int  I = 0;I< 100 ;I++) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		n = rand.nextInt(9) + 1;
		int cnt = rand.nextInt(n * n);
		boolean[][] sGrid = new boolean[n][n];
		boolean[][] tGrid = new boolean[n][n];
		originGrid = new char[2][n][n];

		for (int i = 0; i < 2; i++) {
			int tmp = 0;
			for (int h = 0; h < n; h++) {
				for (int w = 0; w < n; w++) {
					if (tmp < cnt && rand.nextBoolean()) {
						originGrid[i][h][w]  = '#';
					} else
						originGrid[i][h][w] = '.';
				}
				sb.append("\n");
			}
		}
		
		
		int sCnt = 0;
		//幅も取っておく
		int syMin = n;
		int syMax = 0;
		int sxMin = n;
		int sxMax = 0;

		for (int i = 0; i < n; i++) {
			char[] strs = originGrid[0][i];
			for (int j = 0; j < n; j++) {
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
		int sWidth = sxMax - syMin + 1, sHeight = syMax - syMin + 1;

		int tCnt = 0;
		//幅も取っておく
		int tyMin = n;
		int tyMax = 0;
		int txMin = n;
		int txMax = 0;
		for (int i = 0; i < n; i++) {
			char[] strs = originGrid[1][i];
			for (int j = 0; j < n; j++) {
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

		if (tCnt != sCnt) {
			System.out.println("No");
			continue label;
		}
		else if (tCnt < 2 || tCnt == n * n) {
			System.out.println("Yes");
			continue label;
		}

		//Sの正規化(図形の一番下と左の座標を0,0にする)
		boolean[][] nS = normalize(sGrid, sHeight, sWidth, syMin, syMax, sxMin, sxMax);

		//Tの正規化
		boolean[][] nT = normalize(tGrid, tHeight, tWidth, tyMin, tyMax, txMin, txMax);
		
		sGrid = null;
		tGrid = null;

		for (int i = 0; i < 4; i++) {
			if (tHeight == nS.length && tWidth == nS[0].length) {
				boolean ok = true;
				for (int y = 0; y < tHeight; y++) {
					for (int x = 0; x <tWidth; x++) {
						if (nS[y][x] != nT[y][x]) {
							ok = false;
							break;
						}
					}
					if (!ok)
						break;
				}
				if (ok)
					System.out.println("OK");
					continue label;
			}
			nS = lotate(nS);
		}
		System.out.println("No");
		 continue label;
		}
		}catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			System.out.println("error n=" + n);
			for(char[][] grid : originGrid) {
				for(char[] row : grid) {
					for( char c : row) {
						sb.append(c);
					}
					sb.append("\n");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			e.printStackTrace();
		}
	}

	//回転
	private static boolean[][] lotate(boolean[][] grid) {
		int originWidth = grid[0].length, originHeight = grid.length;
		boolean[][] result = new boolean[originWidth][originHeight];
		for (int i = 0; i < originHeight; i++) {
			for (int j = 0; j < originWidth; j++) {
				//				result[i][x-1-j] = grid[i][j];
				result[originWidth - 1 - j][i] = grid[i][j];
			}
		}

		return result;
	}

	//正規化
	private static boolean[][] normalize(boolean[][] grid, int height, int width, int yMin, int yMax, int xMin,
			int xMax) {
		boolean[][] result = new boolean[height][width];
		for (int i = yMin; i <= yMax; i++) {
			for (int j = xMin; j <= xMax; j++) {
				result[i - yMin][j - xMin] = grid[i][j];
			}
		}
		return result;
	}

}
