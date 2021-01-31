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
		//
		int[] a=new int[n];
		//全ての開始風船の高さ
		for(int i=0;i<n;i++){
			//そもそも開始地点が候補より高ければfalse
			if(x<H[i])
				return false;

			a[(int)Math.min(n-1,(x-H[i])/S[i])]++;
		}
		//
		for(int i=n-1;i>=1;i--){
			
			if(a[i]<n-i)
				return false;
			a[i-1]+=a[i];
		}
		return true;
	}

}
