package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q034_2 {

	static int N;
	static int[][] time;
	static boolean[][] bad;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		time = new int[N][N];
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			for(int j=0;j<N;j++) {
				time[i][j] = Integer.parseInt(strs[j]);
			}
		}
		int M = Integer.parseInt(reader.readLine());
		bad = new boolean[N][N];
		for(int i=0;i<M;i++) {
			String[] strs = reader.readLine().split(" ");
			int x = Integer.parseInt(strs[0]);
			int y = Integer.parseInt(strs[1]);
			bad[x-1][y-1] = true;
			bad[y-1][x-1] =true;
		}
		
	}

	static int slove() throws IOException {
		int ans = Integer.MAX_VALUE;
		//順列の全パターン
		int loopCnt = 1;
		//順番
		int[] line = new int[N];
		for(int i = 0;i<N;i++) {
			loopCnt *= i+1;
			line[i] = i;
		}
		
		for(int i=0;i<loopCnt + 1; i++) {
//			for(int x:line)
//				System.out.print(x);
//			System.out.println("");
			if(isOk(line)) {
				int total = 0;
				for(int j=0;j<N;j++) {
					total += time[line[j]][j];
				}
				ans = Math.min(ans, total);
			}
			line = permutation(line);
		}
		
		return ans == Integer.MAX_VALUE ? -1 : ans;
    }
	
	
	private static int[] permutation( int[] arr) {
		int idx1 = -1;
		//arr[i] < arr[i+1]となる最後の要素を取得
		for(int i= 0;i<arr.length-1;i++) {
			if(arr[i] < arr[i+1]) {
				idx1 = i; 
			}
		}
		if (idx1 == -1){
			return arr;
		}
		
		//arr[i]より大きい最後の要素
		int idx2 = idx1+1;
		for(int i = idx2;i<arr.length;i++) {
			if(arr[idx1] < arr[i]) {
				idx2 = i;
			}
		}
		
		//idx1とidx2の入れ替え
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
		
		//idx1以降の要素を反転
		int loopCnt =( arr.length - 1 - idx1) /2; 
		for(int i= 0;i< loopCnt;i++) {
			int tmpValue = arr[idx1 + 1 + i];
			arr[idx1 + 1 + i] = arr[arr.length-1-i];
			arr[arr.length-1-i]= tmpValue;
		}
		
		return arr;
	}
	
	private static boolean isOk(int[] arr) {
		for(int i = 0;i< N-1;i++) {
			if(bad[arr[i]][ arr[i+1]]) {
				return false;
			}
		}
		return true;
	}
}