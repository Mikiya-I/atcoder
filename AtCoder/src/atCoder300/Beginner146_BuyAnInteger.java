package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner146_BuyAnInteger {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner146_BuyAnInteger This = new Beginner146_BuyAnInteger();
		long ans =This.slove();
		System.out.println(ans);
	}

	public long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		reader.close();
		final long A = Long.parseLong(strs[0]);
		final long B = Long.parseLong(strs[1]);
		final long X = Long.parseLong(strs[2]);

		//二分探索木
		long left = 0;
		long right = X+1;

		while(right -left >1) {
			long mid = (left+right)/2;
			long val = String.valueOf( mid).length();
			if(A  <=  (X-B*val)/mid)
				left= mid;
			else
				right = mid;
		}
		if( left >= (long)1e9)
			left = (long)1e9;
		return left;
	}
}
