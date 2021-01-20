package algorithm;

public class NextPermutation {
	//順列全探索(サンプル用順列の数を戻す)
	int nextPermutation(int[] arr) {
		boolean next = true;
		int current =1;
		while(next) {
			next = false;
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
