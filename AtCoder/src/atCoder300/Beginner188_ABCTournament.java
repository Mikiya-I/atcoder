package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner188_ABCTournament {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		int N = Integer.parseInt(reader.readLine());
	    String strs[] = reader.readLine().split(" ");

	    int maxFirstHalf =0;
	    int maxFirstHalfIndex=0;
	    int maxSecondHalf =0;
	    int maxSecondHalfIndex =0;
	    int total = intPow(2,N);
	    int half = total/2;
	    for(int i =0 ;i<total ;i++) {
	    	int current = Integer.parseInt(strs[i]);
	    	if(i<half) {//前半
	    		if(maxFirstHalf<current){
	    			maxFirstHalfIndex=i+1;
	    			maxFirstHalf = current;
	    		}
	    	}else {//後半
	    		if(maxSecondHalf<current) {
	    			maxSecondHalf =current;
	    			maxSecondHalfIndex = i+1;
	    		}
	    	}
	    }

	    System.out.println(maxFirstHalf>maxSecondHalf?maxSecondHalfIndex:maxFirstHalfIndex);


	}

	static int intPow(int base,int pow) {
		int result =1;
		for(int i=0;i<pow;i++) {
			result = result*base;
		}
		return result;
	}

}
