package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class KagamiMochi {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		int result = 1;

	    String str = reader.readLine();

	    int n = Integer.parseInt(str);

	    ArrayList<Integer> mochi = new ArrayList<Integer>();
	    for(int i = 0;i<n;i++) {
	    	int now = Integer.parseInt(reader.readLine());
	    	mochi.add(now);
	    }

	    Collections.sort(mochi);
	    Collections.reverse(mochi);

	    int base = mochi.get(0);

	    for(int i =0;i<n;i++) {
	    	if(base>mochi.get(i)) {
	    		base = mochi.get(i);
	    		result++;
	    	}

	    }

	    System.out.println(result);

	}

}
