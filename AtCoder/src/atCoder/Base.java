package atCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Base{

  public static void main( String[] args ) throws IOException{



    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
    StringTokenizer token = new StringTokenizer(reader.readLine());

    char[] S = reader.readLine().toCharArray();
    String str = reader.readLine();
    String strs[] = reader.readLine().split(" ");
    int I = Integer.parseInt(reader.readLine());

    System.out.println(" ");
  }

  int intPow(int base,int pow) {
		int result =1;
		for(int i=0;i<pow;i++) {
			result = result*base;
		}
		return result;
	}
}



