
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class Beginner218_C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//		 slove();
		//		long ans = slove();
		System.out.println(slove2());
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		TreeMap<Integer, TreeSet<Integer>> S = new TreeMap<Integer, TreeSet<Integer>>();
		TreeMap<Integer, TreeSet<Integer>> T = new TreeMap<Integer, TreeSet<Integer>>();

		int sCnt = 0;
		//最小値も取っておく
		int syMin = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			char[] strs = reader.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (strs[j] == '#') {
					sCnt++;
				}
			}
		}
		//x軸の最小値
		int sxMin = 0;
		for (int i : S.get(syMin)) {
			sxMin = i;
			break;
		}

		int tCnt = 0;
		//最小値も取っておく
		int tyMin = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			char[] strs = reader.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (strs[j] == '#') {
					tyMin = Math.min(i, tyMin);
					if (!T.containsKey(i)) {
						T.put(i, new TreeSet<Integer>(Arrays.asList(j)));
					} else {
						T.get(i).add(j);
					}
					tCnt++;
				}
			}
		}

		if (tCnt != sCnt)
			return "No";
		else if (tCnt < 2)
			return "Yes";

		//Tのx方向の最小値
		int txMin = 0;
		for (int i : T.get(tyMin)) {
			txMin = i;
			break;
		}

		//Sの正規化(左下を0,0にする)
		TreeMap<Integer, TreeSet<Integer>> S2 = new TreeMap<Integer, TreeSet<Integer>>();
		for (int i : S.keySet()) {
			for (int j : S.get(i)) {
				if (S2.containsKey(i - syMin)) {
					S2.get(i - syMin).add(j - sxMin);
				} else {
					S2.put(i - syMin, new TreeSet<Integer>(Arrays.asList(j - sxMin)));
				}
			}
		}

		//Tの正規化(左下を0,0にする)
		TreeMap<Integer, TreeSet<Integer>> T2 = new TreeMap<Integer, TreeSet<Integer>>();
		for (int i : T.keySet()) {
			for (int j : T.get(i)) {
				if (T2.containsKey(i - tyMin)) {
					T2.get(i - tyMin).add(j - txMin);
				} else {
					T2.put(i - tyMin, new TreeSet<Integer>(Arrays.asList(j - txMin)));
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			boolean ok = true;
			for (int y : T2.keySet()) {
				TreeSet<Integer> s = S2.get(y);
				TreeSet<Integer> t = T2.get(y);
				for (int x : t) {
					if (s == null || !s.contains(x)) {
						ok = false;
						break;
					}
				}
				if (!ok) {
					break;
				}
			}
			if (ok)
				return "Yes";
			S2 = lotate(S2);
		}

		return "No";
	}

	//90度回転&正規化
	private static TreeMap<Integer, TreeSet<Integer>> lotate(TreeMap<Integer, TreeSet<Integer>> grid) {
		TreeMap<Integer, TreeSet<Integer>> result = new TreeMap<Integer, TreeSet<Integer>>();
		TreeMap<Integer, TreeSet<Integer>> result2 = new TreeMap<Integer, TreeSet<Integer>>();
		int xMin = Integer.MAX_VALUE;
		int yMin = Integer.MAX_VALUE;
		for (int i : grid.keySet()) {
			int y = i;
			for (int j : grid.get(i)) {
				int x = -j;
				if (!result.containsKey(y)) {
					result.put(y, new TreeSet<Integer>(Arrays.asList(x)));
				} else {
					result.get(y).add(x);
				}
			}
		}

		for (int i : result.keySet()) {
			yMin = i;
			break;
		}

		for (int i : result.get(yMin)) {
			xMin = i;
			break;
		}

		for (int i : result.keySet()) {
			for (int j : result.get(i)) {
				if (result2.containsKey(i - yMin)) {
					result2.get(i - yMin).add(j - xMin);
				} else {
					result2.put(i - yMin, new TreeSet<Integer>(Arrays.asList(j - xMin)));
				}
			}
		}

		return result;
	}

	public static String slove2() throws IOException {
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
		int sWidth = sxMax - syMin + 1, sHeight = syMax - syMin + 1;

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
		int tWidth = txMax - tyMin + 1, tHeight = tyMax - tyMin + 1;

		if (tCnt != sCnt)
			return "No";
		else if (tCnt < 2 || tCnt == N * N)
			return "Yes";

		//ここから
		//Sの正規化(図形の一番下と左の座標を0,0にする)
		boolean[][] nS = new boolean[sHeight][sWidth];
		for (int i = syMin; i <= syMax; i++) {
			for (int j = sxMin; j <= sxMax; j++) {
				nS[i - syMin][j - sxMin] = sGrid[i][j];
			}
		}

		//Tの正規化
		boolean[][] nT = new boolean[tHeight][tWidth];
		for (int i = tyMin; i <= tyMax; i++) {
			for (int j = txMin; j <= txMax; j++) {
				nS[i-tyMin][j-txMin] = sGrid[i][j];
			}
		}

		for (int i = 0; i < 4; i++) {
			if (tHeight == nS.length && tWidth == nS[0].length) {
				boolean ok = true;
				for (int y = tyMin; y <= tyMax; y++) {
					for (int x = txMin; x <= txMin; x++) {
						if (nS[y][x] != nT[y][x]) {
							ok = false;
							break;
						}
					}
					if (!ok)
						break;
				}
				if (ok)
					return "Yes";
			}

			nS = lotate(nS);
		}
		return "No";
	}
	
	private static boolean[][] lotate(boolean[][] grid){
		int x= grid[0].length, y = grid.length;
		boolean[][] result = new boolean[x][y];
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				result[x-1-i][y-1-j] = grid[y][x];
			}
		}
		
		return result;
	}
}
