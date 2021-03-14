package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner195_Comma {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long  N = Long.parseLong(reader.readLine());
		if(N<1000) {
			System.out.println(0);
			return;
		}
		int point=1;
		while(N>=Math.pow(1000, point+1))
			point ++;

		long ans =0;
		for(int i=1;i<=point;i++)
			ans+= N-Math.pow(1000, i)+1;
		System.out.println(ans);
	}
}
