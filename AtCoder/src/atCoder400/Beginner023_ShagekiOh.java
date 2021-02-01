package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner023_ShagekiOh {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());

		long[] H = new long[N];
		long[] S = new long[N];
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(reader.readLine());
			H[i] = Integer.parseInt(token.nextToken());
			S[i] = Integer.parseInt(token.nextToken());
		}

		long left = 0;
		//候補の上限
		long right = (long) 2e14;//doubleで2×10の14乗

		//二分探索木
		while (right - left > 1) {
			long mid = (left + right) >> 1;//普通に2で割るより速い
			if(check(mid,H,S))
				right = mid;
			else
				left = mid;
		}

		System.out.println(right);
	}

	//その候補が成立するか
	static boolean check(long x,long[] H,long[] S){
		int n=H.length;

		//秒数ごとに基準値の限界になる風船の数(例:3個の風船がx秒を超えると基準値を超える)
		int[] a=new int[n];
		//全ての開始時点での風船の高さ
		for(int i=0;i<n;i++){
			//そもそもの開始地点が候補より高ければfalse
			if(x<H[i])
				return false;

			//候補の秒数([(基準-開始位置)/秒数=猶予]とN-1(最大秒数)のうち小さいほうを配列に入れる)
			int b =(int)Math.min(n-1,(x-H[i])/S[i]);

			//その秒の風船の数を増やす
			a[b]++;
		}

		//1秒から実行
		for(int i=n-1;i>=1;i--){
			//現在の秒数より限界の風船が多い場合(秒数が足りない)候補を棄却
			//例:a[2]=3、n-i=2の時 →2秒で3個は割れないから棄却
			if(a[i]<n-i)
				return false;
			//1秒前にそれまでの限界の風船の個数を足す
			//例:5秒に限界になる風船が2個、4秒に限界になる風船が1個ある
			//5秒までに2個+4秒までに1個割る必要がある→4秒までに3個割る必要がある
			a[i-1]+=a[i];
		}
		return true;
	}

}
