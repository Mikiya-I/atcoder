package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner119_SyntheticKadomatsu {
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int ans = slove();
		System.out.println(ans);
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int A = Integer.parseInt(strs[1]);
		final int B = Integer.parseInt(strs[2]);
		final int C = Integer.parseInt(strs[3]);

		int[] takeLength = new int[N];
		for (int i = 0; i < N; i++) {
			takeLength[i] = Integer.parseInt(reader.readLine());
		}
		//2桁区切りのbit全探索
		//全ての竹をA,B,Cに使うか何も使わないの4つの状態で全探索する
		int ans = Integer.MAX_VALUE;
		int loop = (int) Math.pow(4, N);
		for (int i = 0; i < loop; i++) {
			//そのケースでのA,B,Cの長さ
			int tmpA = 0, tmpB = 0, tmpC = 0;
			int tmpCost = 0;
			for (int j = 0; j < N; j++) {
				//00 なにも使わない　01A  10B 11C
				int status = (i >> 2 * j) & 3;
				if (status == 1) {
					//すでにAになにかしらの竹が使われていた場合はcost+10
					if (tmpA > 0) {
						tmpCost += 10;
					}
					tmpA += takeLength[j];
				} else if (status == 2) {
					//すでにBになにかしらの竹が使われていた場合はcost+10
					if (tmpB > 0) {
						tmpCost += 10;
					}
					tmpB += takeLength[j];
				} else if (status == 3) {
					//すでにCになにかしらの竹が使われていた場合はcost+10
					if (tmpC > 0) {
						tmpCost += 10;
					}
					tmpC += takeLength[j];
				}
			}
			//A,B,Cのいずれかが使用された竹が無ければケースの棄却
			if(tmpA==0||tmpB == 0 || tmpC == 0) {
				continue;
			}
			tmpCost += Math.abs(tmpA-A) + Math.abs(tmpB-B) + Math.abs(tmpC-C);
			ans = Math.min(tmpCost, ans);
		}

		return ans;
	}
}
