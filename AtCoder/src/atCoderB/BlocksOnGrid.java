package atCoderB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BlocksOnGrid {

	public static void main(String[] args) throws IOException {

		 BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		    String[] strs = reader.readLine().split(" ");

		    int height = Integer.parseInt(strs[0]);
		    int width = Integer.parseInt(strs[1]);

		    int min = 100;
		    int current = 0;
		    int result = 0;

		    List<Integer> rowSum = new ArrayList<Integer>();

		    for(int i = 0 ;i<height;i++) {
		    	String[] line = reader.readLine().split(" ");
		    	current = 0;
		    	for(int j=0;j<width;j++) {
		    		if(Integer.parseInt(line[j])<min) {
		    			min = Integer.parseInt(line[j]);
		    		}
		    		current += Integer.parseInt(line[j]);
		    	}
		    	rowSum.add(current);
		    }


		    for(int sum :rowSum) {
		    	result += (sum-min*width);
		    }
		    System.out.println(result);

	}

}
