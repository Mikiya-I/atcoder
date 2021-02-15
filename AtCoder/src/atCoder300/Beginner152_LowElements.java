package atCoder300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner152_LowElements {

	public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    StringTokenizer token = new StringTokenizer(reader.readLine());

	    final int N = Integer.parseInt(token.nextToken());

	    token = new StringTokenizer(reader.readLine());
	    int min = Integer.MAX_VALUE;
	    int ans = 0;
	    for(int i= 0;i<N;i++) {
	    	int current = Integer.parseInt(token.nextToken());
	    	if(current  <= min ) {
	    		min = current;
	    		ans++;
	    	}
	    }
	    System.out.println(ans);
	}

}
