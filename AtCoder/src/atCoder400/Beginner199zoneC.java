package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Beginner199zoneC {

	public static void main(String[] args) throws IOException {
		int ans = slove();
		System.out.println(ans);
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		int[][] arr = new int[N][5];
		for (int i = 0; i < N; i++) {
			String[] strs = reader.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strs[0]);
			arr[i][1] = Integer.parseInt(strs[1]);
			arr[i][2] = Integer.parseInt(strs[2]);
			arr[i][3] = Integer.parseInt(strs[3]);
			arr[i][4] = Integer.parseInt(strs[4]);
		}
		int ok = 0;
		int ng = (int) (1e9 + 1);
		while (ng - ok > 1) {
			int mid = (ng + ok) / 2;
			if (judge(mid, arr)) {
				ok = mid;
			} else {
				ng = mid;
			}
		}

		return ok;
	}

	public static boolean judge(int mid, int[][] arr) {
		//integerで基準値を満たすかを保持(bitで立っているところが基準値を超えている)
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int tmp = 0;
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] >= mid) {
					tmp |= 1 << j;
				}
			}
			hashSet.add(tmp);
		}
		//hashSetにしたため0~31までの32パターンだけになる
		List<Integer> list = new ArrayList<>(hashSet);
		//max32パターンで全探索
		for(int i=0;i<list.size();i++) {
			for(int j=i;j<list.size();j++) {
				for(int k=j;k<list.size();k++) {
					//31になるパターンがあれば基準値を満たす選び方が存在する
					if((list.get(i) | list.get(j) | list.get(k)) == 31) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
