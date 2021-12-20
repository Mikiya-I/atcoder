
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner232_C {
	static int N,M;
	static int[] takahashiArr;
	static int[] aokiArr;
	static boolean[][] aokiPath;
	static Pair[] tArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
//		slove2();
		//		long ans = slove();

		System.out.println(slove());
	}
	static class Pair{
		int a,b;
		Pair(int a,int b){
			this.a = a;
			this.b = b;
		}
	}

	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		tArr = new Pair[M];
		for(int i=0;i<M;i++) {
			strs =reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0])-1;
			int b = Integer.parseInt(strs[1])-1;
			tArr[i] = new Pair(a,b);
		}
		
		aokiPath = new boolean[N][N];
		for(int i=0;i<M;i++) {
			strs =reader.readLine().split(" ");
			int c = Integer.parseInt(strs[0])-1;
			int d = Integer.parseInt(strs[1])-1;
			aokiPath[c][d] = true;
			aokiPath[d][c] = true;
		}
		reader.close();
	}

	public static String slove() throws IOException {
		//順列の全パターン
//		int loopCnt = 1;
		//順番
		int[] line = new int[N];
		for(int i = 0;i<N;i++) {
//			loopCnt *= i+1;
			line[i] = i;
		}
		boolean ans = nextPermutation(line);
		if(ans)
			return "Yes";
		
		return "No";
	}
	

	static boolean nextPermutation(int[] arr) {
		boolean next = true;
		while(next) {
			next = false;
			int i;
			//諸々処理
			if(isSame(arr))
				return true;
			
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
		return false;
	}
	
	static boolean isSame( int[] P) {
		for(int i=0;i<M;i++) {
			int a = tArr[i].a;
			int b = tArr[i].b;
			
			int tmpC = P[a];
			int tmpD = P[b];
			if(!aokiPath[tmpC][tmpD] || ! aokiPath[tmpC][tmpD])
				return false;
		}
		return true;
	}
}