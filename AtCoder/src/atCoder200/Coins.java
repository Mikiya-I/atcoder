package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coins{
  public static void main( String[] args ) throws IOException{
    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
    int coins500   = Integer.parseInt(reader.readLine());
    int coins100  = Integer.parseInt(reader.readLine());
    int coins50  = Integer.parseInt(reader.readLine());
    int dvalue    = Integer.parseInt(reader.readLine());
    int value     = dvalue;
    int result 	=0;

    for(int i=0;i<=coins500;i++) {
    	for(int j =0; j<=coins100;j++) {
    		int current =value-500*i-100*j;
			if(current <= 50*coins50&& current >=0) {
				result ++;
			}
    	}
    }

    System.out.println(result);
  }
}

