package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner054_Moore_Law {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double P = Double.parseDouble(reader.readLine());
		double high = P+1;
		double low = -1;
		while(high-low >0.00000001) {
			double d = high -low;
			if((low+high*2)/3>(low*2+high)/3) {
				high -= d/3;
			}else {
				low +=+d/3;
			}
		}
		System.out.println(high);
	}
}
