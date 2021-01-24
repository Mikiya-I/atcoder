package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class MituiSumitomoShintaku2019_LuckyPIN {

	public static void main( String[] args ) throws IOException{

	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    int N = Integer.parseInt(reader.readLine()); //桁数
	    char[] S = reader.readLine().toCharArray();//文字列

	    HashSet<Character> set = new HashSet<Character>();
	    int ans =0;
	    for(int i=0;i<N-2;i++) {
	    	if(!set.contains(S[i]) ){
	    		set.add(S[i]);
	    		HashSet<Character> set2 = new HashSet<Character>();

		    	for(int j=i+1;j<N-1;j++) {
		    		if(!set2.contains(S[j])) {
		    			set2.add(S[j]);
		    			HashSet<Character> set3= new HashSet<Character>();

			    		for(int k=j+1;k<N;k++) {
			    			set3.add(S[k]);
			    		}
			    		ans += set3.size();
		    		}
		    	}
	    	}
	    }



	    System.out.println(ans);
	}

}
