package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner196_RoundDown {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		char[] c = str.toCharArray();

		int i=0;

		for(char now:c){
			if(now == '.')
				break;
			i++;
		}

		System.out.println(str.substring(0, i));
	}
}
