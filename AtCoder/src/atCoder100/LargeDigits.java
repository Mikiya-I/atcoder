package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargeDigits {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );


	    String[] strs = reader.readLine().split(" ");
	    char[] A = strs[0].toCharArray();
	    char[] B = strs[1].toCharArray();

	    int a =0;
	    int b = 0;

	    for(char current:A) {
	    	a += Character.getNumericValue(current);
	    }

	    for(char current:B) {
	    	b += Character.getNumericValue(current);
	    }

	    System.out.println(a>=b?a:b);

	}

}
