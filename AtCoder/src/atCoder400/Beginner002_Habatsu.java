package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner002_Habatsu {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		boolean[][] line = new boolean[N][N];

		if (M == 0) {
			System.out.println(1);
			return;
		}

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(token.nextToken())-1;
			int y = Integer.parseInt(token.nextToken())-1;

			line[x][y] = true;
			line[y][x] = true;
			line[x][x] = true;
			line[y][y] = true;
		}

		int max = 1;
		//全パターン
		for (int i = 0, pattern = 1 << N; i < pattern; i++) {
			//そのパターンでの人数
			int current = Integer.bitCount(i);
			//現時点のパターンで最大値を更新できないならスキップ(計算量削減)
			if (current <= max)
				continue;
			boolean ok =true;
			label:
			//基準になる人
			for (int j = 0; i>>j > 0 ; j++) {
				//bitが立っている人
				if(((i>>j)&1) ==1) {
					//基準になっている人と知り合い/本人か(iより後の桁)
					for(int k=0;i>>k > 0;k++) {
						//bitが立っている人
						if(((i>>k)&1)==1) {
							//パターンと人脈に矛盾があった場合はパターンを棄却
							if(line[j][k] != true) {
								ok = false;
								break label;
							}
						}
					}
				}
			}
			if(ok) max= current;

		}

		System.out.println(max);
	}

}
