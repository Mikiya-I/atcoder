package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner197_ORXOR {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner197_ORXOR This = new Beginner197_ORXOR();
		int ans =This.slove();
		System.out.println(ans);
	}

	public int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		reader.close();
		int[] A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = Integer.parseInt(strs[i]);
		int ans = Integer.MAX_VALUE;

		//bit全探索
		for(int i=0;i<	(1<<19);i++) {
			//xorの値
			int xored = 0;
			//orの値
			int ored = 0;
			//N個の数値
			for (int j = 0; j <= N; j++) {
				if (j < N)
					ored |= A[j];
				//最後まで行くかビットが立っているか
				if (j == N|| (i >> j & 1)==1) {
					//現時点でのxorを計算し、orを初期化
					xored ^= ored;
					ored = 0;
				}
			}
			if(xored < ans)
				ans = xored;
		}

		return ans;
	}

//	public int slove() throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		final int N = Integer.parseInt(reader.readLine());
//		String[] strs = reader.readLine().split(" ");
//		reader.close();
//		int[] A = new int[N];
//		for(int i=0;i<N;i++)
//			A[i] = Integer.parseInt(strs[i]);
//		int ans = Integer.MAX_VALUE;
//		//先頭からの累積和
//		int[] firstBit = new int[N];
//		firstBit[0] = A[0];
//		for(int i=1;i<N;i++){
//			firstBit[i]= firstBit[i-1] | A[i];
//		}
//		//末尾からの累積和&最小値計算
//		int[] secondBit = new int[N];
//		secondBit[0] = A[N-1];
//		for(int i=1;i<N;i++) {
//			secondBit[i] = secondBit[i-1]	|	A[N-1-i];
//
//			if(ans> (secondBit[i]^firstBit[N-1-i]))
//				ans =  secondBit[i]^firstBit[N-1-i];
//		}
//
//		return ans;
//	}
}
