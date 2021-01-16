package keyence_programmingContest2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSequences2 {

	public static void main(String[] args) throws IOException {

	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    int N = Integer.parseInt(reader.readLine());
	    int[] arrayA = new int[N];
	    int[] arrayB = new int[N];

	    StringTokenizer token = new StringTokenizer(reader.readLine());
	    for(int i= 0;i<N;i++) {
	    	arrayA[i] = Integer.parseInt(token.nextToken());
	    }

	    token = new StringTokenizer(reader.readLine());
	    for(int i =0;i<N;i++) {
	    	arrayB[i] = Integer.parseInt(token.nextToken());
	    }

	    long aMax =0;
	    int aIndex=0;
	    long bMax = 0;
	    long c =0;;
	    int bIndex =0;
	    boolean change=false;

	    for(int i=0;i<N;i++) {
	    	//Bの最大値
	    	if(arrayB[i]>bMax) {
	    		bMax = arrayB[i];
	    		bIndex = i;
	    		change = true;
	    	}
	    	//Aの最大値
	    	if(arrayA[i]>aMax) {
	    		aMax = arrayA[i];
	    		aIndex = i;
	    		change = true;
	    	}
	    	//値が変化した場合
	    	if(change) {
	    		if(aIndex<=bIndex) {
	    			c=aMax*bMax;
	    		}else {
	    			c=Math.max(aMax*arrayB[i], c);
	    		}
	    	}
	    	System.out.println(c);
	    }

	}

}
