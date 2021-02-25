package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner170_ForbiddenList {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int X = Integer.parseInt(strs[0]);
		final int N = Integer.parseInt(strs[1]);

		if(N ==0) {
			System.out.println(X);
			return;
		}

		//-1か101の絶対値が小さい方を基準とする
		int ans = X<=101-X?0:101;
		//存在する数値を入れていく
		boolean [] nums = new boolean[101];
		String strs2[] = reader.readLine().split(" ");
		for(int i=0;i<N;i++)
			nums[Integer.parseInt(strs2[i])] = true;

		//存在しない値で計算
		for(int i=1;i<101;i++) {
			if(!nums[i] ) {
				//絶対値が小さければans更新
				if(Math.abs(X-i)<Math.abs(X-ans)){
					ans = i;
				}else if( Math.abs(X-i)==Math.abs(X-ans) && i < ans) {
					ans =i;
				}
			}
		}
		System.out.println(ans);
	}
}

