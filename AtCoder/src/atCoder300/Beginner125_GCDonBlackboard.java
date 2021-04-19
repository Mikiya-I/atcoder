package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner125_GCDonBlackboard {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(slove());
		
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] nums = reader.readLine().split(" ");
		reader.close();
		int[] arr = new int[N ];
		for (int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(nums[i]);
		}
		//i番目の要素の前後に関する累積和
		//i番目未満の要素の公約数
		int[] smaller = new int[N];
		//i番目以降の要素の公約数
		int[] more = new int[N];

		//i番目未満の最大公約数の累積和
		for (int i = 1; i <N; i++) {
			smaller[i] = gcd(arr[i-1],smaller[i-1]);
		}

		//i番目以上の最大公約数の累積和
		for (int i = N-2; i >=0; i--) {
			more[i] = gcd(arr[i+1],more[i+1]);
		}
		
		//先頭or末尾に0を代入(端を消した場合はもう片方の値がそのまま使われる)
//		smaller[1]=0;
//		more[N-1] = 0;
		
		int ans = 0;
		for(int i = 0;i<N;i++) {
			ans = Math.max(ans, gcd(smaller[i],more[i]));
		}
		return ans;
	}

	//ユークリッドの互除法(メソッド名はgreatest common divisorの略)
	static int  gcd(int x, int y) {
		if(x==0)
			return y;
		if(y==0)
			return x;
		int max = Math.max(x, y);
		int min = Math.min(x, y);
		int mod = max%min;
		while (mod >0) {
			max = min;
			min = mod;
			mod = max % min;
		}
		return min;
	}
}
