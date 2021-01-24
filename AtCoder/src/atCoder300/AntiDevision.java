package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AntiDevision {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );


	    String[] strs = reader.readLine().split(" ");

	    long min = Long.parseLong(strs[0]);
	    long max = Long.parseLong(strs[1]);

	    long div1 = Long.parseLong(strs[2]);
	    long div2 = Long.parseLong(strs[3]);

	    long range = max-min+1;
	    long commonDevisor =0;
	    long commonMaltiple =0;

	    long big=div1>div2 ? div1 : div2;
	    long small=div1>div2 ? div2 : div1;

	    boolean hasMod =true;
//	    ユークリッドの互除法
	    while(hasMod) {
	    	long mod=big%small;
	    	if(mod==0) {
	    		commonDevisor = small;
	    		break;
	    	}
	    	big = small;
	    	small = mod;
	    }

	    commonMaltiple = div1 / commonDevisor * div2;
	    System.out.println(range-(countDivision(min, max, div1)+countDivision(min,max,div2)-countDivision(min,max,commonMaltiple)));
	}

	static long countDivision (long min, long max,long devisor) {
		long result = 0;

		result = max/devisor - (min-1)/devisor;

		return result;
	}

}
