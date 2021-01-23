package atCoderA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner189_Slot {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		String str = reader.readLine();

		char[] c=str.toCharArray();

		boolean ans =true;
		if(c[0] != c[1] || c[1] != c[2]) ans =false;

		System.out.println(ans?"Won":"Lost");
	}

}
