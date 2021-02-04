package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner183_Travel {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());

		int[][] root = new int[N+1][N+1];

		for(int i= 1;i<=N;i++) {
			token = new StringTokenizer(reader.readLine());
			for(int j=1;j<=N;j++) {
				root[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		//順列全探索用の配列
		int[] pattern = new int[N-1];
		for(int i = 0,j=2	;i<N-1	;i++,j++) {
			pattern[i] = j;
		}
		//配列の長さ(計算短縮)←2ms早くなった
		int len = pattern.length;

		int ans = 0;
		boolean next = true;
		while(next) {
			next = false;
			int current =0;
			//順列内での合計
			for(int x= 1;x<len;x++) {
				current += root[pattern[x-1]][pattern[x]];
			}
			//1とそのパターンの最初に行くところ
			current += root[1][pattern[0]];
			//そのパターンの最後と1の距離
			current += root[1][pattern[len-1]];
			//合計がkと同じか
			if(current == K) ans++;

			int i;
			//順列の並び替え
			for(i = len -2;i>=0;i--) {
				if(pattern[i] < pattern[i+1]) {
					next = true;
					break;
				}
			}

			if(i < 0) break;

			for(int j = len-1;j>=0;j--) {
				if(pattern[j]> pattern[i]) {
					int tmp = pattern[i];
					pattern[i] = pattern[j];
					pattern[j] = tmp;

					for(int k=i+1,n=len-1	;k<n	;k++,n--) {
						int temp = pattern[k];
						pattern[k] = pattern[n];
						pattern[n] = temp;
					}
					break;
				}
			}

		}

		System.out.println(ans);

	}

	//組み合わせ総数
//	static long PairRange(int n,int r) {
//		long ans = factrial(n)/;
//		return ans;
//	}

	//階乗
//	static long factrial(int n) {
//		long ans = n;
//		int i = 1;
//		while(i>n) {
//			ans *= n-i;
//			i++;
//		}
//		return ans;
//	}

}
