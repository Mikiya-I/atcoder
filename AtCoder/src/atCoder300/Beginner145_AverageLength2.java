package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Beginner145_AverageLength2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		//各地点のx,y
		int[] x = new int[N+1];
		int[] y = new int[N+1];
		//順列全探索用の配列
		int[] pattern = new int[N];

		for(int i=1;i<=N;i++) {
			token = new StringTokenizer(reader.readLine());
			x[i] = Integer.parseInt(token.nextToken());
			y[i] = Integer.parseInt(token.nextToken());
			pattern[i-1] =i;
		}

		//順列全探索
		boolean next = true;
		double sum = 0;
		int count =0;
		while(next) {
			next = false;

			//現在の合計
			for(int i = 0;i<N-1;i++) {
				sum += Math.sqrt(Math.pow(x[pattern[i]]-x[pattern[i+1]], 2)+Math.pow(y[pattern[i]]-y[pattern[i+1]], 2));
			}
			count++;

			//並び替え
			for(int i= N-2;0<= i;i--) {
				//i<i+1となる一番後ろのiを見つける
				if(pattern[i] < pattern[i+1]) {
					//pattern[i]より大きいpattern[j]のうち一番後ろを見つける
					for(int j=N-1;i<j;j--) {
						if(pattern[i] < pattern[j]) {
							//iとjを入れ替える
							int tmp = pattern[i];
							pattern[i] = pattern[j];
							pattern[j] = tmp;
							//iより後ろを反転
							for(int k = i+1,right = N-1; k<right;k++,right--) {
								int tmp2 = pattern[k];
								pattern[k] = pattern[right];
								pattern[right] = tmp2;
							}
							break;
						}
					}
					next = true;
					break;
				}
			}
		}

		System.out.println(sum/count);
	}
}