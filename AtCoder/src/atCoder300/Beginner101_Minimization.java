package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner101_Minimization {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long ans = slove();
		System.out.println(ans);
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int K = Integer.parseInt(strs[1]);
		
		if(N==K) {
			return 1;
		}
		
		strs = reader.readLine().split(" ");
		
		int minIndex =0;
		for(int i= 0;i<N;i++) {
			if(Integer.parseInt(strs[i])==1) {
				minIndex =i;
				break;
			}
		}
		int param1 = minIndex/(K-1);
		int param2 = ((minIndex%(K-1)+(N-minIndex-1)%(K-1)))/(K-1);
		int param3 = ((minIndex%(K-1)+(N-minIndex-1)%(K-1)))%(K-1) ==0 ? 0:1;
		int param4 = (N-minIndex-1)/(K-1);
//		if(N%K != 0) {
//			ans ++;
//		}
		
		return param1+param2+param3+param4;
	}
}
//5 3
//2 3 4 1 5