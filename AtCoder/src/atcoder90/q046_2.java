package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q046_2 {
	
	static int N;
	static long[] A;
	static long[] B;
	static long[] C;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
//		 slove();
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		A = new long[46];
		B = new long[46];
		C = new long[46];
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			A[Integer.parseInt(strs[i] )%46]++;
		}
		strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			B[Integer.parseInt(strs[i] )%46]++;
		}
		strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			C[Integer.parseInt(strs[i] )%46]++;
		}
		reader.close();
	}

	static long slove() throws IOException {
		long ans = 0;
		for(int i=0;i<46;i++) {
			for(int j=0;j<46;j++) {
				for(int k = 0;k<46;k++) {
					if((i+j+k)%46 ==0) {
						ans += A[i]*B[j]*C[k];
					}
				}
			}
		}
		return ans;
	}
}