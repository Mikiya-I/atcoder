package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner191_VanishiingPitch {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int v= Integer.parseInt(token.nextToken());
		int t= Integer.parseInt(token.nextToken());
		int s= Integer.parseInt(token.nextToken());
		int d= Integer.parseInt(token.nextToken());

		System.out.println((v*t > d || v* s < d) ? "Yes":"No");
	}

}
