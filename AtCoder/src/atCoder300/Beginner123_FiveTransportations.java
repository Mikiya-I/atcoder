package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner123_FiveTransportations {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long ans =slove();
		System.out.println(ans);
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long min = Long.MAX_VALUE;
		final long N = Long.parseLong(reader.readLine());
		for(int i=0;i<5;i++) {
			min = Math.min(min,Long.parseLong(reader.readLine()));
		}
		reader.close();
		
		return N%min==0?N/min+4:N/min+5;
	}
}
