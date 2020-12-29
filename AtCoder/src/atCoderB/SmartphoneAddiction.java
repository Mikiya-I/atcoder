package atCoderB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmartphoneAddiction {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    String[] strs = reader.readLine().split(" ");

	    int N = Integer.parseInt(strs[0]);//充電
	    int M = Integer.parseInt(strs[1]);//繰り返し回数
	    int T = Integer.parseInt(strs[2]);//帰宅時刻
	    int Max = N;
	    int startTime = 0;
	    String result = "Yes";

	    for(int i = 0;i<M;i++) {
	    	String[] str2 = reader.readLine().split(" ");
	    	int A = Integer.parseInt(str2[0]);
	    	int B = Integer.parseInt(str2[1]);

	    	N -= A-startTime;

	    	if(N<=0) {
	    		result = "No";
	    		break;
	    	}

	    	N = N+B-A>=Max?Max:N+B-A;

	    	startTime = B;

	    }

	    if(N-T+startTime<=0) {
	    	result = "No";
	    }

	    System.out.println(result);
	}

}
