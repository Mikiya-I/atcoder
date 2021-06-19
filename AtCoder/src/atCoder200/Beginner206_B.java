package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner206_B {


	public static void main(String[] args) throws NumberFormatException, IOException {

		long  ans =slove();
		System.out.println(ans);
	}

	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int  N = Integer.parseInt(reader.readLine());
		long left = 1;
		long right = N;
		while(right - left >1){
			long mid = (right +left )/2;
			if((1+mid)*mid/2 >=N){
				right = mid;
			}else {
				left = mid;
			}
		}
		return right;
	}
}
