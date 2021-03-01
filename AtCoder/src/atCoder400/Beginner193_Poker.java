package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner193_Poker {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		final long K =Long.parseLong(reader.readLine());

		int[] takahashiHand = new int[10];
		int[] aokiHand = new int[10];
		int [] cards = new int [10];

		//高橋
		char[] str = reader.readLine().toCharArray();
		for(int i=0;i<4;i++) {
			takahashiHand[str[i]-'0']++;
			cards[str[i]-'0']++;
		}

		//青木
		char[] str2 = reader.readLine().toCharArray();
		for(int i=0;i<4;i++) {
			aokiHand[str2[i]-'0']++;
			cards[str2[i]-'0']++;
		}

		//全探索
		long win = 0;
		for(int i=1;i<10;i++) {
			int tScore = 0;
			//残りの枚数の計算用
			int pattern[] = cards.clone();

			int[]  takahashi =takahashiHand.clone();
			takahashi[i]++;
			long remainTakahashi = K-pattern[i];
			pattern[i]++;

			//Kを超えたらそのパターンを破棄
			if(pattern[i] >K) {
				continue;
			}
			//そのパターンの合計
			for(int l= 1;l<10;l++)
				tScore += l*Math.pow(10, takahashi[l]);
			for(int j= 1;j<10;j++) {
				int aScore=0;
				int[]  aoki =aokiHand.clone();
				aoki[j]++;
				long remainAoki = K-pattern[j];
				pattern[j]++;
				//Kを超えたらそのパターンを破棄
				if(pattern[j] >K) {
					continue;
				}
				//そのパターンの合計
				for(int l= 1;l<10;l++)
					aScore += l*Math.pow(10, aoki[l]);

				//判定
				if(tScore > aScore)
					win+= remainTakahashi*remainAoki;
			}
		}

		long total = ((K * 9) - 8) * ((K * 9) - 9);
		System.out.println((double)win/total);
	}
}

