package atCoder300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Beginner164_gacha {

	public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    final int N = Integer.parseInt(reader.readLine());

	    Set <String>set = new HashSet<> ();
	    for(int i=0;i<N;i++) {
	    	set.add(reader.readLine());
	    }
	    System.out.println(set.size());
	}
}
