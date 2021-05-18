package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner090_C {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long ans = slove();
		System.out.println(ans);
	}

	
    public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final long N = Integer.parseInt(strs[0]);
		final long M = Integer.parseInt(strs[1]);

		//カードの総数
		long total = N*M;
		//隣接するカード+1が奇数なら裏になる(奇数回裏返すから)
		long ans ;
		//1枚だけのケース
		if(total ==1) {
			return 1;
		}
		//1列/行のケース()
		if(total == Math.max(N, M)) {
			ans = total-2;
		}
		//2列/行のケース(全てのカードが偶数回裏返される)
		else if (total == 2*Math.max(M, N)) {
			ans = 0;
		}
		//それ以上(外周の分だけ引く)
		else {
			ans = total - N*2 - (M-2)*2;
		}
		
		return ans;
    }
}
