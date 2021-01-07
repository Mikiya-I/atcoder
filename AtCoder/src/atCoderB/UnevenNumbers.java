package atCoderB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnevenNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {

		 BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    int N = Integer.parseInt(reader.readLine());


	    if(N<10) {
	    	System.out.println(N);
	    }else if(N<100) {//~99
	    	System.out.println(9);
	    }else if (N<1000) {//~999
	    	System.out.println(N-90);
	    }else if (N<10000) {//~9999
	    	System.out.println(909);
	    }else if(N<100000){
	    	System.out.println(N-9090);
	    }else {
	    	System.out.println(90909);
	    }

	}

}
