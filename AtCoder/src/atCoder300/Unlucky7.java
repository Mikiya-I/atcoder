package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unlucky7 {

	public static void main(String[] args) throws IOException {

		 BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		     int n = Integer.parseInt(reader.readLine());
		     int result =0;
		     boolean flag = false;

		     for(int i=1 ; i<=n;i++) {
		    	 flag = false;
		    	 int current =i;
		    	 while(current>=7){
		    		 if(current%10==7) {
		    			 flag = true;
		    			 break;
		    		 }
		    		 current/=10;
		    	 }

		    	 current =i;
		    	 while(current>=7&&!flag) {
		    		 if(current %8 ==7 ) {
		    			 flag = true;
		    			 break;
		    		 }
		    		 current /=8;
		    	 }

		    	 if(flag) {
		    		 result ++;
		    	 }
		     }




		    System.out.println(n-result);

	}

}
