package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner199zone_UFO {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		String str = reader.readLine();
		char[] c = str.toCharArray();
		
		int ans =0;
		for(int i=0;i<9;i++) {
			if(c[i]== 'Z'&& c[i+1]=='O'&& c[i+2]=='N'&&c[i+3]=='e') {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
