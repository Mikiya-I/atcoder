package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner190_Magic3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		int sec = Integer.parseInt(token.nextToken());
		int dmg = Integer.parseInt(token.nextToken());

		boolean canHit =false;
		for(int i=0;i<N;i++) {
			token = new StringTokenizer(reader.readLine());
			if(Integer.parseInt(token.nextToken())<sec && Integer.parseInt(token.nextToken()) >dmg) {
				canHit =true;
				break;
			}
		}

		System.out.println(canHit?"Yes" : "No");
	}

}
