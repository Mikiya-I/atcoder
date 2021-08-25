package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q032 {
	static int[][] grid;
	static boolean[][] bad;

	public static void main(String[] args) throws IOException {
		//		slove();
		System.out.println(slove());
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] strs = reader.readLine().split(" ");
			for (int j = 0; j < N; j++)
				grid[i][j] = Integer.parseInt(strs[j]);
		}
		bad = new boolean[N][N];
		int M = Integer.parseInt(reader.readLine());
		for (int i = 0; i < M; i++) {
			String[] strs = reader.readLine().split(" ");
			int x = Integer.parseInt(strs[0]) - 1;
			int y = Integer.parseInt(strs[1]) - 1;
			bad[x][y] = true;
			bad[y][x] = true;
		}
		long ans = -1;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}
		ans = nextPermutation(arr, ans);
		return ans;
	}

	//順列全探索
	static long nextPermutation(int[] arr,long ans) {
		boolean next = true;
		while(next) {
			next = false;
			int i;
			boolean notBad = true;
			long tmpSum =0;
			//パターンの判定
			for(int idx = 0;idx <arr.length-1;idx++) {
				if(bad[arr[idx]] [arr[idx+1]]) {
					notBad = false;
					break;
				}
				tmpSum += grid[arr[idx]][idx];
			}
			tmpSum += grid[arr[arr.length-1]][arr.length-1];
			if(notBad) {
				if(ans != -1)
					ans = Math.min(ans, tmpSum);
				else
					ans = tmpSum;
			}
			
			//隣り合う要素が昇順(a[i] < a[i+1])になっている一番大きい i を見つける
			for(i = arr.length-2;i>=0;i--) {
				if(arr[i] <arr[i+1]) {
					break;
				}
			}
			//i が見つからなかったら終わり
			if(i <0) break;

			//a[i]より大きい値のうち一番後ろの値a[j]を見つける
			for(int j= arr.length-1;j>=0;j--) {
				//iとjを入れ替える
				if(arr[i] < arr[j]) {
					next = true;
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					//i+1以下を反転
					for(int k= i+1,n=arr.length-1;k<n;k++,n--) {
						int temp = arr[k];
						arr[k] = arr[n];
						arr[n] = temp;
					}
					break;
				}
			}
		}
		return ans;
	}
}
