package atCoder300;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.TreeMap;

public class Beginner113_ID {
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		slove();
	}

	public static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);

		ArrayList<TreeMap<Integer, Integer>> map = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			map.add(new TreeMap<Integer, Integer>());
		}
		for (int i = 0; i < M; i++) {
			strs = reader.readLine().split(" ");
			int p = Integer.parseInt(strs[0]) - 1;
			int y = Integer.parseInt(strs[1]);
			map.get(p).put(y, i);
		}
		
		//入力順に県Noとその県で何番目に作られたかを保持
		int[][] arr = new int[M][2];
		for (int i = 0; i < N; i++) {
			//入力順と何番目か()
			int[] u = { i, 1 };
			map.get(i).forEach((j, k) -> {
				//出力用の配列の最初の要素に県
				arr[k][0] = u[0];
				//配列の2番目の要素に何番目のmapに入っていたかを代入
				arr[k][1] = u[1];
				u[1]++;
			});
		}
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<M;i++) {
			writer.write(String.format("%06d", arr[i][0] + 1)+String.format("%06d", arr[i][1] )+"\n");
		}
		writer.flush();
		writer.close();
	}
}
