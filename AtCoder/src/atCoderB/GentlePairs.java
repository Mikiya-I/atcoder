package atCoderB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GentlePairs {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    String str = reader.readLine();

	    int n = Integer.parseInt(str);

	    if(n<=1) {
	    	System.out.println("0");
	    	return;
	    }

	    int result =0;
	    ArrayList<ArrayList<Integer>> chart = new ArrayList<>();


	    for(int i=0;i<n;i++) {
	    	String[] strs = reader.readLine().split(" ");
	    	int x = Integer.parseInt(strs[0]);
	    	int y = Integer.parseInt(strs[1]);
	    	ArrayList<Integer> current = new ArrayList<Integer>();
	    	current.add(x);
	    	current.add(y);
	    	chart.add(current);
	    }

	    for(int i=0;i<n-1;i++) {
	    	for(int j=i+1;j<n;j++) {
	    		int xChange = chart.get(i).get(0)-chart.get(j).get(0);
	    		int yChange = chart.get(i).get(1)-chart.get(j).get(1);
	    		double inclination=(double)yChange/(double)xChange;
	    		if(-1<=inclination &&	inclination<=1) {
	    			result ++;
	    		}
	    	}
	    }

	    System.out.println(result);
	}

}
