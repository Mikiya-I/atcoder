package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner227_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 slove();
//		System.out.println(slove());
	}

	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		int ans =0;
//		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			if(!checkOK(Integer.parseInt(strs[i])))
				ans++;
//			arr[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.println(ans);
	}
	
	static boolean checkOK(int x) {
		int maxA = (x-3)/7;
		for(int i=maxA;i>0;i--) {
			if((x-3*i)%(4*i+3)==0)
				return true;
		}
		return false;
	}
}
