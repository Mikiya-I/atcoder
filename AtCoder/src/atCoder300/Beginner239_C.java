
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner239_C {
	static long x1,x2,y1,y2;
	static long mod = 998244353;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove2());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		x1 = Integer.parseInt(strs[0]);
		y1 = Integer.parseInt(strs[1]);
		x2 = Integer.parseInt(strs[2]);
		y2 = Integer.parseInt(strs[3]);
		reader.close();
	}

	public static String slove() throws IOException {
		//パターン1
		double X = (x1+x2)/2;
//		double Y = 5-Math.pow(X, 2);
		double Y = Math.sqrt(5 - X*X)-y1;
		if( check(X,Y)) {
			return "Yes";
		}
		//パターン2
		Y = (y1+y2)/2;
//		X = 5-Math.pow(Y, 2);
		X = Math.sqrt(5 - Y*Y)-x1;
		if( check(X,Y)) {
			return "Yes";
		}
		return "No";
	}
	
	static String slove2() {
		long X = x1 -3;
		while(X<=x1+2) {
			X++;
			if(X==x1)
				continue;
			if(Math.abs(X-x1)==2) {
				if(Math.pow(X-x2, 2)+Math.pow(y2-(y1-1), 2)== 5 ||Math.pow(X-x2, 2)+Math.pow(y2-(y1+1),2)== 5  )
					return "Yes";
			}else {
				if(Math.pow(X-x2, 2)+Math.pow(y2-(y1-2), 2)== 5 ||Math.pow(X-x2, 2)+Math.pow(y2-(y1+2),2)== 5  )
					return "Yes";
			}
		}
		return "No";
	}
	
	static boolean check(double x,double y) {
		double p1 = Math.pow(x1-x, 2)+Math.pow(y1 -y, 2);
		double p2 = Math.pow(x2-x, 2)+Math.pow(y2 -y, 2);
		
		return p1 == p2 && p1==5;
	}

}