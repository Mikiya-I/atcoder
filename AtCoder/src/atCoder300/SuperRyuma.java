package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperRyuma {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//配列として扱う場合
	    String[] ab = reader.readLine().split(" ");
	    String[] cd = reader.readLine().split(" ");

	    int a = Integer.parseInt(ab[0]);
	    int b = Integer.parseInt(ab[1]);

	    int c = Integer.parseInt(cd[0]);
	    int d = Integer.parseInt(cd[1]);

//	    移動なし
	    if(a==c && b==d) {
	    	System.out.println("0");
	    	return;
	    }

	    if(a-b==c-d || a+b == c+d || Math.abs(a-c)+Math.abs(b-d)<=3) {
	    	System.out.println("1");
	    	return;
	    }

	    if(Math.abs(a-c)+Math.abs(b-d)<=6 || Math.abs((a-b)-(c-d))<=3 || Math.abs((a+b)-(c+d))<=3 || (a+b+c+d)%2==0) {
	    	System.out.println("2");
	    	return;
	    }

	    System.out.println("3");
	}

}
