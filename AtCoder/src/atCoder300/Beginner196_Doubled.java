package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner196_Doubled {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String n = reader.readLine();
		reader.close();
		Beginner196_Doubled This = new Beginner196_Doubled();
		long x =This.slove(n);
		System.out.println(x);
	}

	public long slove(String str) throws IOException {
		int  half = (str.length())/2;

		long ans=0;

		if(str.length()%2==0) {
			String firstHalf = str.substring(0, half);
			String secondHalf = str.substring(half);
			int firstN = Integer.parseInt(firstHalf);
			int secondN = Integer.parseInt(secondHalf);
			ans = firstN>secondN?firstN-1:firstN;
		}else {
			ans = (long) (Math.pow(10, half)-1);
		}
		return ans;
	}
}
