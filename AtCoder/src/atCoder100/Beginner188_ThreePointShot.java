package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner188_ThreePointShot {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    String strs[] = reader.readLine().split(" ");
	    int X = Integer.parseInt(strs[0]);
	    int Y = Integer.parseInt(strs[1]);

	    if(Math.abs(X-Y)<3) {
	    	System.out.println("Yes");
	    }else {
	    	System.out.println("No");
	    }

	}

}
