
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Beginner222_C {
	static TreeMap<Integer,TreeSet<Integer>> rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//		 slove();
		//		long ans = slove();
		System.out.println(slove());
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		
		//勝ち数
		int[] wins = new int[2*N];
//		Map<Integer,Integer> points = new HashMap<>();
//		for(int i=0;i<2*N;i++) {
//			points.put(i, 0);
//		}
		//順位(勝ち数順→番号順)
		rank  = new TreeMap<Integer, TreeSet<Integer>>(Comparator.reverseOrder());
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i=0;i<2*N;i++) {
			set.add(i);
		}
		rank.put(0, set);
		
		//試合数
		int[] games = new int[2*N];
		//i番目の人のj番目に出す手
		char[][] grid= new char[2*N][M];
		for(int i=0;i<2*N;i++) {
			char[] tmp = reader.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				grid[i][j] = tmp[j];
			}
		}
		
		for(int i=0;i<M;i++) {
			TreeMap<Integer,TreeSet<Integer>> newRank =new TreeMap<Integer, TreeSet<Integer>>(Comparator.reverseOrder());
			for(int j=0;j<N;j++) {
				int rank1 = calcRank(2*j);
				int rank2 = calcRank(2*j+1);
				char hand1 = grid[rank1] [ games[rank1] ];
				char hand2 = grid[rank2] [ games[rank2] ];
				//引き分け
				if(hand1 == hand2) {
					if(!newRank.containsKey(wins[rank1]))
						newRank.put(wins[rank1], new TreeSet<Integer>());
					if(!newRank.containsKey(wins[rank2]))
						newRank.put(wins[rank2], new TreeSet<Integer>());
					newRank.get(wins[rank1]).add(rank1);
					newRank.get(wins[rank2]).add(rank2);
					games[rank1]++;
					games[rank2]++;
					continue;
				}
				if(win1(hand1,hand2)) {
					if(!newRank.containsKey(wins[rank1]+1))
							newRank.put(wins[rank1]+1, new TreeSet<Integer>());
					newRank.get(wins[rank1]+1).add(rank1);
					wins[rank1]++;
					if(!newRank.containsKey(wins[rank2]))
						newRank.put(wins[rank2], new TreeSet<Integer>());
				newRank.get(wins[rank2]).add(rank2);
				}else {
					if(!newRank.containsKey(wins[rank2]+1))
							newRank.put(wins[rank2]+1, new TreeSet<Integer>());
					newRank.get(wins[rank2]+1).add(rank2);
					wins[rank2]++;
					if(!newRank.containsKey(wins[rank1]))
						newRank.put(wins[rank1], new TreeSet<Integer>());
				newRank.get(wins[rank1]).add(rank1);
				}
				games[rank1]++;
				games[rank2]++;
			}
			rank = newRank;
		}
		for(int i = 0;i<2*N;i++) {
			sb.append(calcRank(i)+1);
			sb.append("\n");
		}
		
		return sb.toString();
	}
	static int calcRank( int calcRank) {
		int sum =0;
		for(int key : rank.keySet()) {
			if(calcRank <= sum+rank.get(key).size()) {
				int remain = sum-calcRank;
				for(int i : rank.get(key)) {
					if(remain==0) {
						return i;
					}
					remain++;
				}
			}
			sum += rank.get(key).size();
		}
		return 0;
	}
	
	static boolean win1(char hand1,char hand2) {
		if((hand1 == 'G' && hand2 == 'C')||(hand1 == 'C' && hand2=='P') || (hand1 == 'P' && hand2=='G'))
			return true;
		else
			return false;
	}
}
