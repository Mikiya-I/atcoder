package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner126_DiceAndCoin {

	public static void main(String[] args) throws NumberFormatException, IOException {

		double ans =slove();
		System.out.println(ans);
	}

	public static double slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		reader.close();
		final double N = Integer.parseInt(strs[0]);
		final double K = Integer.parseInt(strs[1]);
		double noCoin = 0;
		double needCoin=0;
		//コインがいらないケース
		if(N>= K)
			noCoin = (N-K+1)/N;
		
		//コインがいるケース
		int needCoinCase = (int)Math.min(N, K-1);
		for(int i=1;i<=needCoinCase;i++) {
			int coinCount= 0;
			double cal = i;
			while(true) {
				cal *= 2;
				coinCount++;
				if(cal>=K)
					break;
			}
			noCoin += 1/(N*Math.pow(2,coinCount));
		}
		
		return needCoin+noCoin;
	}

}
