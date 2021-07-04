package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner208_B {


	public static void main(String[] args) throws NumberFormatException, IOException {

		long  ans =slove();
		System.out.println(ans);
	}

	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long p =Long.parseLong(reader.readLine());
		long ans =0;
		long tmp =1;
		long cal = 1;
		while ( p != 0) {
			while(p >=tmp*(cal+1)) {
				cal++;
				tmp*=cal;
			}
			ans += p/tmp;
			p%= tmp;
			tmp =1;
			cal = 1;
		}
		return ans;
	}
}
