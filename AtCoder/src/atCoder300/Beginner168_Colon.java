package atCoder300;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beginner168_Colon {

	public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    String[] str = reader.readLine().split(" ");
	    final int A = Integer.parseInt(str[0]);
	    final int B = Integer.parseInt(str[1]);
	    final double  H= Integer.parseInt(str[2]);
	    final double  M= Integer.parseInt(str[3]);

	    double c=Math.cos(Math.toRadians(30*H+M/2 - 6*M));
	    System.out.println(Math.sqrt(A*A+B*B-2*A*B*c));
	}
}
