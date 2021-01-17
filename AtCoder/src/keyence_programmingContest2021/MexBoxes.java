package keyence_programmingContest2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MexBoxes {

	public static void main(String[] args) throws IOException {


	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    StringTokenizer token = new StringTokenizer(reader.readLine());

	    int N = Integer.parseInt(token.nextToken());
	    int K = Integer.parseInt(token.nextToken());

	    int[] a = new int[N];
	    token = new StringTokenizer(reader.readLine());
	    for(int i= 0;i<N;i++) {
	    	a[i] = Integer.parseInt(token.nextToken());
	    }
	    reader.close();

	    Arrays.sort(a);

	    if(a[0] != 0) {
	    	System.out.println(0);
	    	return;
	    }

	    long result = 0;
	    int leftBox = K;
	    int arrayStart =0;
	    for(int i=0;i<N;i++) {
	    	for(int j =0;arrayStart<N ;j++,arrayStart++) {
	    		if(a[arrayStart] != i) {
	    			if(j<leftBox) {
		    			result += (leftBox-j)*i;
		    			leftBox = j;
	    			}
	    			break;
	    		}else if(arrayStart == N-1) {
	    			result += leftBox*(i+1);
	    			leftBox = 0;
	    		}
	    	}
	    	if(leftBox <=0) {
	    		break;
	    	}

	    }
	    System.out.println(result);
	}

}
