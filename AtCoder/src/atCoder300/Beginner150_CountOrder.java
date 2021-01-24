package atCoder300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner150_CountOrder {

	public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    StringTokenizer token = new StringTokenizer(reader.readLine());

	    int N = Integer.parseInt(token.nextToken());

	    token = new StringTokenizer(reader.readLine());
	    StringTokenizer token2 = new StringTokenizer(reader.readLine());
	    int[] defaultArray = new int[N];
	    int[] P = new int[N];
	    int[] Q = new int[N];
	    for(int i= 0;i<N;i++){
	    	defaultArray[i] = i+1;
	    	P[i] = Integer.parseInt(token.nextToken());
	    	Q[i] = Integer.parseInt(token2.nextToken());
	    }
	    int ans = nextPermutation(defaultArray,P,Q);
	    System.out.println(ans);

	}

	//階乗
	private static int factorial(int number) throws Exception {
		if(number <0) throw new Exception("負数は入力不可");
		//0の階乗は1になる
		int result =1;
		for(int i= number;1<=i;i--) {
			result *= i;
		}
		return result;
	}

	static //順列全探索
	int nextPermutation(int[] arr,int[] arr2,int[] arr3) {
		boolean next = true;;
		int p = 0;
		int q = 0;
		int current =1;
		boolean findP = false;
		boolean findQ =false;
		while(next) {
			next = false;
			int i;
			//配列の判定
			if(findP == false) {
				boolean same =true;;
				for(int x = 0; x<arr.length;x++) {
					if(arr[x] != arr2[x]) {
						same = false;
						break;
					}
				}
				if(same) {
					findP =true;
					p= current;
				}
			}
			if(findQ == false) {
				boolean same =true;;
				for(int x = 0; x<arr.length;x++) {
					if(arr[x] != arr3[x]) {
						same = false;
						break;
					}
				}
				if(same) {
					findQ =true;
					q = current;
				}
			}

			if(findP&&findQ) {
				return Math.abs(p-q);
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
					current ++;
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
		return 0;
	}

	//順列全探索(サンプル用順列の数を戻す)
		int nextPermutation(int[] arr) {
			boolean next = true;
			int current =0;
			while(next) {
				int i;
				//隣り合う要素が昇順(a[i] < a[i+1])になっている一番大きい i を見つける
				for(i = arr.length-2;i<=0;i--) {
					if(arr[i] <arr[i+1]) {
						break;
					}
				}
				//i が見つからなかったら終わり
				if(i <0) break;

				//配列の一番後ろにあるa[i]より大きい値a[j]を見つける
				for(int j= arr.length;j>=0;j--) {
					//iとjを入れ替える
					if(arr[i] < arr[j]) {
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
						//i+1以下を反転
						for(int k= i+1,n=arr.length-1;k<n;k++,n++) {
							int temp = arr[k];
							arr[k] = arr[n];
							arr[n] = temp;
						}
					}
					System.out.println(arr);
					current ++;
				}
			}
			return current;
		}

}
