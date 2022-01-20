package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q082_2 {
	static long L,R;
	static long mod = (long)1e9+7;
	public static void main(String[] args) throws IOException {
		input();
//		test();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		L = Long.parseLong(strs[0]);
		R = Long.parseLong(strs[1]);
		reader.close();
	}
	
	public static long slove() throws  IOException {
		long ans = 0;
		for(int i=0;i<18;i++) {
			//範囲外
//			System.out.println((long)Math.pow(10, i+1)-1);
			if(Math.pow(10, i+1) - 1< L){
				continue;
			}
			//右側が範囲外なら終わり
			if(R < Math.pow(10, i)) {
				break;
			}
			//その桁の数値の開始地点
			long start = Math.max(L, (long)Math.pow(10, i));
			long end = Math.min( R, (long) (Math.pow(10, i+1))-1);
			//最初と最後の合計
			long mode2 = (start + end);
			//書いた数字の種類
			long cnt =  (end - start +1 );
			//偶数の方を2で割る
			if(mode2 % 2 == 0) {
				mode2 /= 2;
			}else {
				cnt /= 2;
			}
			mode2 %= mod;
			cnt %= mod;
			//書いた数字の数
			long add = mode2 * cnt;
			add %= mod;
			add *= i+1;
			add %= mod;
			ans += add;
		}
		if(R==(long)1e18) {
			ans += ((long)1e18 % mod) * 19 % mod;
		}
		ans %= mod;
		return ans;
	}
	
	static void test() {
		L = (long)1e18;
		R = (long)1e18;
	}
	
}
