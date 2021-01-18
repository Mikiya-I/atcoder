package atCoderC;

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
	    int[] P = new int[N];
	    int[] Q = new int[N];
	    for(int i= 0;i<N;i++){
	    	P[i] = Integer.parseInt(token.nextToken());
	    	Q[i] = Integer.parseInt(token2.nextToken());

	    }



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

	//順列全探索
//	private static int nextPermutation(int[] array) {
//		int result =0;
//		for(int i =0;i<array.length;i++) {
//
//		}
//
//
//		return result;
//	}

	//順列全探索
	public static boolean nextPermutation(int[] arr) {
		boolean next = false;
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

			for(int j= arr.length;j>=0;j--) {
				if(arr[i] < arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return next;

	}

}
