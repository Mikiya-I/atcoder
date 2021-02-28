package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner193_Unexpressed {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		final long N = Long.parseLong(reader.readLine());
		reader.close();

		//愚直解
		int root = (int) Math.sqrt(N)+1;
		long expressed = 0;
		boolean[] count = new boolean[root];

		for(int i=2;i<root;i++) {
			if(!count[i]) {
				for(int j=2;;j++) {
					long current = (long) Math.pow(i, j);
					if(current > N)
						break;
					else
						expressed++;
					if(current < root)
						count[(int) Math.pow(i, j)] = true;
				}
			}
		}
		System.out.println(N-expressed);
	}
}
