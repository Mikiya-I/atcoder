package atCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Base999_Base {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		char[] S = reader.readLine().toCharArray();
		String str = reader.readLine();
		String strs[] = reader.readLine().split(" ");
		int I = Integer.parseInt(reader.readLine());

		System.out.println(" ");
	}

	int intPow(int base, int pow) {
		int result = 1;
		for (int i = 0; i < pow; i++) {
			result = result * base;
		}
		return result;
	}

	//二分探索木
	int binarySearch(int ok,int ng) {
	  while (Math.abs(ok - ng) > 1) {
		  int mid = (ok + ng); // 2
		  if (true)//ここを編集
			  ok = mid;
		  else
			  ng = mid;
	  }
	  return ok;
	}

	//順列全探索(サンプル用に順列の総数)
	int nextPermutation(int[] arr) {
		boolean next = true;
		int current =1;
		while(next) {
			next = false;
			int i;
			//隣り合う要素が昇順(a[i] < a[i+1])になっている一番大きい i を見つける
			for(i = arr.length-2;i<=0;i--) {
				if(arr[i] <arr[i+1]) {
					next = true;
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
					break;
				}
				System.out.println(arr);
				current ++;
			}
		}
		return current;
	}

	int bitAllSearch(int N) {

		//最大値計算用
	    int max = 0;
	    //ループ回数
	    int loop = 1<<N;
	    //全てのケース
	    for(int i = 0;i<loop;i++) {

	    	//桁分の繰り返し
	    	for(int j=0;j<N;j++) {

	    		//ビットが立っている場所を特定
	    		if(((i>>j) & 1)==1)  {

	    			//判定処理


	    		}

	    	}
	    	max ++;
	    }
	    return max;
	}
}
