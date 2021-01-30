package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner190_VeryVeryPrimitiveGame {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    String strs[] = reader.readLine().split(" ");
	    int T = Integer.parseInt(strs[0]);
	    int A = Integer.parseInt(strs[1]);
	    int c = Integer.parseInt(strs[2]);

	    String ans;
	    if(c==0) {
	    	if(T-A >=1) ans ="Takahashi";

	    	else ans = "Aoki";
	    }else {
	    	if(A-T >=1) ans ="Aoki";

	    	else ans = "Takahashi";
	    }

	    System.out.println(ans);
	}

}
