package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATCoder{

  public static void main( String[] args ) throws IOException{



    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

    char[] S = reader.readLine().toCharArray();
    int max = 0;
    int temp = 0;

    for(char current:S) {
    	switch(current) {
    		case 'A':
    		case 'C':
    		case 'G':
    		case 'T':
    			temp ++;
    			if(max<temp) max = temp;
    			break;
    		default:
    			temp = 0;
    			break;
    	}

    }


    System.out.println(max);



  }
}