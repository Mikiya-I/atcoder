package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quizzes {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    String[] strs = reader.readLine().split(" ");

	    int quizNum = Integer.parseInt(strs[0]);
	    int points = Integer.parseInt(strs[1]);

	    String quizResult = reader.readLine();
	    char[] qResult = quizResult.toCharArray();

	    for(int i=0;i<quizNum;i++) {
	    	if(qResult[i]=='o') {
	    		points++;
	    	}else if(points!=0) {
	    		points--;
	    	}
	    }

	    System.out.println(points);

	}

}
