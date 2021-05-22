package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner202_B {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner202_B This = new Beginner202_B();
		String ans =This.slove();
		System.out.println(ans);
	}

	public String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] c = reader.readLine().toCharArray();
		
		for(int i= 0;i<c.length/2;i++) {
			char tmp = c[i];
			c[i] = c[c.length-1-i] ;
			c[c.length-1-i] = tmp;
		}
		
		for(int i=0;i<c.length;i++) {
			if(c[i] == '6') {
				c[i]= '9';
			}else if(c[i] == '9'){
				c[i] = '6';
			}
		}
		return new String(c);
	}
}
