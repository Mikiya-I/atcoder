package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beginner077_SunukeFestival {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());

		int A[] = new int[N];
		int B[] = new int[N];
		int[] C = new int[N];

		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(token.nextToken());
		}

		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(token.nextToken());
		}

		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			C[i] = Integer.parseInt(token.nextToken());
		}
		reader.close();
		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);

		Beginner077_SunukeFestival binary = new Beginner077_SunukeFestival();
		long total =0;
		//二分探索木
		for(int b :B) {
			//ｂがAの最小値以下かCの最大値以上の場合はスキップ
			if(b <=A[0] || b>=C[N-1]) continue;
			int a= binary.lower_bound(A, b);

			int c = binary.upper_bound(C, b);

			total += (long)(a+1)*(long)(N-c);
		}

		System.out.println(total);
	}

	//二分探索(この場合はbaseより大きい最小のindex)
	public int upper_bound(int[] array,int base){
		//右側 条件を満たす最小のindex
		int right = array.length;
		//左側 条件を満たさない最大のindex
		int left = -1;
		while(right - left >1) {
			//中央のindex
			int mid = left + (right -left)/2;
			//真ん中が条件を満たす場合
			if(array[mid] > base) right = mid;
			//満たさない場合
			else left  =mid;
		}

		return right;

	}

	//二分探索(この場合はbaseより小さい最大のindex)
		public int lower_bound(int[] array,int base){
			//右側 条件を満たす最小のindex
			int right = array.length;
			//左側 条件を満たさない最大のindex
			int left = -1;
			while(right - left >1) {
				//中央のindex
				int mid = left + (right -left)/2;
				//真ん中が条件を満たす場合
				if(array[mid] >= base) right = mid;
				//満たさない場合
				else left  =mid;
			}

			return left;

		}

		//↓全探索だと時間切れ
//		int count = 0;
//		for (int i =0,bIndex =0; i<N;i++) {
//			for (int j=bIndex,cIndex=0;j<N;j++) {
//				//AよりBが小さければスキップ
//				if (B[j] <= A[i]) {
//					bIndex = j+1;
//					continue;
//				}
//
//				for (int k=cIndex;k<N;k++) {
//					//BよりCが小さければスキップ
//					if (C[k] <= B[j]) {
//						cIndex = k+1;
//						continue;
//					}
//
//					count++;
//				}
//			}
//		}
//		System.out.println(count);

}
