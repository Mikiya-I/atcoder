package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner191_DigitalGraffiti {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int H = Integer.parseInt(token.nextToken());
		int W = Integer.parseInt(token.nextToken());

		boolean[][] field = new boolean[H][W];

		for(int i= 0;i<H;i++) {
			char[] current = reader.readLine().toCharArray();
				for(int j = 0;j<W;j++) {
					if(current[j] == '#')
						field[i][j] = true;
				}
		}

		int ans =0;
		for(int i=0;i<H-1;i++) {
			for(int j=0;j<W-1;j++) {
				int current =0;
					if(field[i][j]==true)
						current++;
					if(field[i+1][j]==true)
						current++;
					if(field[i][j+1]==true)
						current++;
					if(field[i+1][j+1]==true)
						current++;

				if(current == 1 || current ==3) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
