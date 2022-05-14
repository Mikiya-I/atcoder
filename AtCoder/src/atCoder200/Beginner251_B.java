package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Beginner251_B {
	static int N,W;
	static int[] A;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = Integer.parseInt(strs[i]);
		
		reader.close();
	}

	public static long slove() throws IOException {
		HashSet<Integer> set  = new HashSet<Integer>();
		for(int i=0;i<N;i++) {
			int A1 = A[i];
			if(A1 <= W)
				set.add(A1);
			for(int j=i+1;j<N;j++) {
				int A2 = A[j];
				if(A2 <=W )
					set.add(A2);
				if(A1+A2 <= W)
					set.add(A1+A2);
				for(int k=j+1;k<N;k++) {
					int A3 = A[k];
					if(A3 <= W)
						set.add(A3);
					if(A1+A3 <= W)
						set.add(A1+A3);
					if(A3+A2 <= W)
						set.add(A2+A3);
					if(A1+A2+A3 <= W)
						set.add(A1+A2+A3);
				}
			}
		}
		return set.size();
	}

}