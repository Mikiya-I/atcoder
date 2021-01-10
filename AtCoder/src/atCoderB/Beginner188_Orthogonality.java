package atCoderB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner188_Orthogonality {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		int N = Integer.parseInt(reader.readLine());


	    String A[] = reader.readLine().split(" ");
	    String[] B = reader.readLine().split(" ");
	    int sum =0;
	    for(int i=0;i<N;i++) {
	    	sum += Integer.parseInt(A[i])* Integer.parseInt(B[i]);
	    }

	    System.out.println( sum==0?"Yes" :"No");

	}

}
