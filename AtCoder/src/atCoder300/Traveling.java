package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Traveling {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    String str = reader.readLine();

	    int n = Integer.parseInt(str);

	    boolean ok = true;

	    int startTime =0;
	    int startX = 0;
	    int startY = 0;

	    for(int i=0;i<n;i++) {
	    	String[] strs = reader.readLine().split(" ");
	    	int t = Integer.parseInt(strs[0]);
	    	int x = Integer.parseInt(strs[1]);
	    	int y = Integer.parseInt(strs[2]);
	    	int totalMove = x+y;
	    	int moveCount = t-startTime;

	    	int z = t-totalMove;

	    	if(z<0) {
	    		ok = false;
	    		break;
	    	}

	    	if((t-startTime-Math.abs(startX-x)-Math.abs(startY-y))<0) {
	    		ok = false;
	    		break;
	    	}

	    	if((moveCount-Math.abs(x-startX)-Math.abs(y-startY))%2 == 0) {
	    		startTime = t;
	    		startX = x;
	    		startY = y;
	    	}else {
	    		ok = false;
	    		break;
	    	}

	    }
	    System.out.println(ok?"Yes":"No");
	}

}
