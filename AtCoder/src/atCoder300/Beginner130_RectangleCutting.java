package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner130_RectangleCutting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long startTime = System.currentTimeMillis();
		slove();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}

	public static  void slove() throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String[] strs = reader.readLine().split(" ");
////		reader.close();
//		
//		long W = Integer.parseInt(strs[0]);
//		long H  = Integer.parseInt(strs[1]);
//		long x = Integer.parseInt(strs[2]);
//		 long  y = Integer.parseInt(strs[3]);
//		 
//		
//		 //長方形を2つに分けた時に小さい方の面積が最大になるのは図形を半分にした時
////		 double s = (double)W*(double)H/2;
////		 double s = W*1.0*H*1.0/2;
//		 if(W*1.0/2 == x*1.0 && H*1.0/2 == y*1.0)
//			 System.out.println(( (double)W*(double)H/2)+" "+ 1);
//		 else
//			System.out.println(((double)W*(double)H/2)+" "+0);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] data = br.readLine().split(" ");
	    long w = Integer.parseInt(data[0]);
	    long h = Integer.parseInt(data[1]);
	    double x = Integer.parseInt(data[2]);
	    double y = Integer.parseInt(data[3]);
	    int multipleAns = (x==w/2.0 && y==h/2.0 ? 1 : 0);
	    
	    System.out.println(w*h/2.0 + " " + multipleAns);
	}
}
