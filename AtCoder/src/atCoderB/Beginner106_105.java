package atCoderB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner106_105 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    int N =Integer.parseInt(reader.readLine());

	    int ans=0;

	    if(N%2==0) N--;

	    for(int i = 1;i<=N;i+=2){
	    	int divisor =0;
	    	for(int j =1;j<=i;j+=2) {
	    		if(i%j==0) divisor++;
	    	}
	    	if(divisor==8) ans++;
	    }

	    System.out.println(ans);
	}

}
