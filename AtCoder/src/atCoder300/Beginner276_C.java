
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner276_C {
	static int N;
	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
//		for(int i=0;i<100;i++) {
//			if(!test())
//				return;
//		}
//		System.out.println("OK");
	}

	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		p = new int[N];
		for(int i=0;i<N;i++) {
			p[i] = Integer.parseInt(strs[i]);
		}
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		beforePermutation(p);
		for(int num : p) {
			System.out.print(num + " ");
		}
		return sb.toString();
	}
	
	static void beforePermutation(int[] arr) {
		int i = 0;
		//隣り合う要素が昇順(a[i] > a[i+1])になっている一番大きい i を見つける
		for(i = arr.length-2;i>=0;i--) {
			if(arr[i] >arr[i+1]) {
				break;
			}
		}

		//a[i]より小さい値のうち一番後ろの値a[j]を見つける
		for(int j= arr.length-1;j>=0;j--) {
			//iとjを入れ替える
			if(arr[i] > arr[j]) {
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
}