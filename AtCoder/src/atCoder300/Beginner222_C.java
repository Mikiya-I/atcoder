
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Beginner222_C {
	static TreeMap<Integer, TreeSet<Integer>> rank;

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

		char[][] hands = new char[2 * N][M];
		//選手番号と勝ち数
		ArrayList<Player> players = new ArrayList<>();
		for (int i = 0; i < 2 * N; i++)
			players.add(new Player(i, 0));

		for (int i = 0; i < N * 2; i++)
			hands[i] = reader.readLine().toCharArray();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				char hand1 = hands[players.get(j*2).num][i];
				char hand2 = hands[players.get(j*2+1).num][i];
				//引き分け
				if(hand1==hand2)
					continue;
				//勝った方の勝ち数+1
				if(win1(hand1,hand2))
					players.get(j*2).win++;
				else
					players.get(j*2+1).win++;
			}
			players.sort((player1,player2) -> player1.win == player2.win? player1.num - player2.num : player2.win-player1.win);
		}
		for(Player p: players) {
			sb.append(p.num+1);
			sb.append("\n");
		}
		
		return sb.toString();
	}

	static boolean win1(char hand1, char hand2) {
		if ((hand1 == 'G' && hand2 == 'C') || (hand1 == 'C' && hand2 == 'P') || (hand1 == 'P' && hand2 == 'G'))
			return true;
		else
			return false;
	}
}

class Player {

	int num, win;

	public Player(int num, int win) {

		this.num = num;
		this.win = win;

	}

}