package algorithm;

public class NextPermutation {
	
	int nextPermutation(int[] arr) {
		boolean next = true;
		int cnt = 0;
		while(next) {
			next = false;
			int i;
			//諸々処理
			for(int num : arr) {
				System.out.print(num);
			}
			System.out.println();
			
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
					cnt++;
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
		return cnt;
	}
}
