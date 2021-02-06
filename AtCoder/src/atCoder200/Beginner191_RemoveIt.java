package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner191_RemoveIt {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		int X = Integer.parseInt(token.nextToken());

		StringBuilder sb =new StringBuilder("");
		token = new StringTokenizer(reader.readLine());

		for(int i = 0;i<N;i++) {
			String current = token.nextToken();
			if(X != Integer.parseInt(current))
				sb.append(current + " ");
		}

		System.out.println(sb.toString());
	}

}
