package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner192_BaseN {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		final String X = reader.readLine();
		int[] arr = new int[X.length()];
		final Long M = Long.parseLong(reader.readLine());
		reader.close();

		if(X.length() == 1) {
			if(M < Integer.parseInt(X))
				System.out.print(0);
			else
				System.out.print(1);
			return;
		}

		//最大の数字を求める
		long n=0;
		for(int i=0;i< X.length();i++) {
			arr[i] = X.charAt(i)-'0';
			if(n< arr[i])
				n= arr[i];
		}

		//二分探索
		long left = n;
		long right = M+1;
		while(right-left >1) {
			long mid = (right+left)/2;
			if(Function(arr,M,mid))
				left = mid;
			else
				right = mid;
		}

		System.out.println(left-n);
	}

	//n進数の判定
	public static boolean Function(int[] arr ,long M,long n) {
		long current = 0;
		for(int i:arr) {
			long x = (M-i)/n;
			if(current > x) {
				return false;
			}
			current = current*n+i;
		}

		return true;
	}
}
