package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner199_InterSection {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner199_InterSection This = new Beginner199_InterSection();
		int ans =This.slove();
		System.out.println(ans);
	}

	public int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(reader.readLine());
		
		int[] A = new int[n];
		int maxA =0;
		int[] B = new int[n];
		int minB = 1001;
		String[] strs = reader.readLine().split(" ");
		for(int i= 0;i<n;i++) {
			A[i] = Integer.parseInt(strs[i]);
			maxA =Math.max(maxA, A[i]);
		}
		strs = reader.readLine().split(" ");
		reader.close();
		for(int i=0;i<n;i++) {
			B[i] = Integer.parseInt(strs[i]);
			minB = Math.min(B[i], minB);
		}

		if(maxA > minB) {
			return 0;
		}else {
			return minB-maxA+1;
		}
//		boolean[] checkList = new boolean[1001];
//		for(int i=0;i<n;i++) {
//			for(int j=1;j<=1000;j++) {
//				if()
//			}
//		}
	}
}
