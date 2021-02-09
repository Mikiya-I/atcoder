package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MituiSumitomoShintaku2019_LuckyPIN2 {

	public static void main( String[] args ) throws IOException{

	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    int N = Integer.parseInt(reader.readLine()); //桁数
	    char[] S = reader.readLine().toCharArray();//文字列

	    int ans =0;
	    //0~1000まで全部試す
	    for(int i = 0;i<1000;i++) {
	    	//1桁目
	    	for(int j=0;j<N-2;j++) {
	    		if(i/100 == Character.getNumericValue(S[j])){
	    			//2桁目
	    			for(int k=j+1;k<N-1;k++) {
	    				if(i%100/10 == Character.getNumericValue(S[k])) {
	    					//3桁目
	    					for(int l=k+1;l<N;l++) {
	    						if(i%10 == Character.getNumericValue(S[l])) {
	    							ans++;
	    							break;
	    						}
	    					}
	    					break;
	    				}
	    			}
	    			break;
	    		}
	    	}
	    }

	    System.out.println(ans);
	}

}
