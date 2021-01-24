package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner189_MandarinOrange {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		int[] A = new int[N];
		int[] minList = new int[N];
		int ans = 0;

		token = new StringTokenizer(reader.readLine());

		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(token.nextToken());
		}

		for(int i=0;i<N;i++) {
			int min=Integer.MAX_VALUE;
			for(int j=i;j<N;j++) {
				if(min>A[j]) min= A[j];
				if(ans < min*(j-i+1)) ans = min*(j-i+1);
			}
		}

		System.out.println(ans);



	}
}
