package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner054_Moore_Law {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double P = Double.parseDouble(reader.readLine());
		double high = 3000000d;
		double low = 0;

		for(int i=0;i<1000;i++){
			//low側の1/3
			double mid1 = low + (high - low) / 3;
			//high側
			double mid2 = low + (high - low) * 2 / 3;

			if(cal(P,mid1)<cal(P,mid2)) {
				high = mid2;
			}else {
				low = mid1;
			}
		}
		System.out.println(cal(P,high));
		System.out.println("");
	}

	static double cal(double P,double x) {
		double ans = x + P/Math.pow(2, x/1.5);
        return ans;
	}
}
