package atCoder300;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beginner159_MaximumVolume {

	public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    final int L = Integer.parseInt(reader.readLine());
	    reader.close();

	 //愚直解
	    double x = (double)L/3;
	    System.out.println(Math.pow(x,3));
	}

}
