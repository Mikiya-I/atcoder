package atCoderB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EightyOne {

	 public static void main( String[] args ) throws IOException{

		    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		    int N = Integer.parseInt(reader.readLine());

		    if(N>81) {
		    	System.out.println("No");
		    	return;
		    }

		    for(int i=1;i<=9;i++) {
		    	if(N/i<=9 && N%i ==0) {
		    		System.out.println("Yes");
		    		return;
		    	}
		    }
		    System.out.println("No");

		  }

}
