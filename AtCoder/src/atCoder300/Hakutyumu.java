package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hakutyumu {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    String s = reader.readLine();

	    char[] genbun = s.toCharArray();

	    if(genbun.length<5) {
	    	System.out.println("NO");
	    	return;
	    }


	    for(int i =0;i<genbun.length;i+=5) {
	    	try {
		    	//先頭5文字で判定
		    	if(String.valueOf(genbun, i, 5).equals("dream")) {
		    		if(String.valueOf(genbun, i+5, 2).equals("er")) {
		    			if(genbun.length!=i+7) {
		    				if(!String.valueOf(genbun, i+5, 3).equals("era")) {
		    					i +=2;
		    				}
		    			}else {
		    				System.out.println("YES");
		    				return;
		    			}
		    		}
		    	}else if (String.valueOf(genbun, i, 5).equals("erase")) {
		    		if(genbun[i+5]=='r') {
		    			i +=1;
		    		}
		    	}else {
		    		System.out.println("NO");
		    		return;
		    	}
	    	}catch (java.lang.IndexOutOfBoundsException e) {
    			if(genbun.length == i+5||genbun.length==i) {
    				System.out.println("YES");
    			}else {
    				System.out.println("NO");
    			}
    			return;
			}
	    }
	    System.out.println("YES");
	}

}
