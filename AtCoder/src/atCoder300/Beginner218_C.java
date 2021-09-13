
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
		System.out.println(slove());
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		TreeMap<Integer, TreeSet<Integer>> S = new TreeMap<Integer, TreeSet<Integer>>();
		TreeMap<Integer, TreeSet<Integer>> T = new TreeMap<Integer, TreeSet<Integer>>();
//		boolean[][] sGrid = new boolean[N][N];
//		boolean[][] tGrid = new boolean[N][N];

		int sCnt = 0;
		//最小値も取っておく
		int syMin = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			char[] strs = reader.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (strs[j] == '#') {
					syMin = Math.min(syMin, i);
					if (!S.containsKey(i)) {
						S.put(i, new TreeSet<Integer>(Arrays.asList(j)));
					} else {
						S.get(i).add(j);
					}
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
			for(int y: T2.keySet()) {
				TreeSet<Integer> s = S2.get(y);
				TreeSet<Integer> t = T2.get(y);
				for(int x:t) {
					if(s== null  || !s.contains(x)) {
						ok = false;
						break;
					}
				}
				if(! ok) {
					break;
				}
			}
			if(ok)
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
				int x =  - j;
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
	
}
