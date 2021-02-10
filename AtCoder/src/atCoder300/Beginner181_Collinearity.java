package atCoder300;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner181_Collinearity {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		final int N = Integer.parseInt(token.nextToken());
		Point[] p = new Point[N];

		for(int i=0;i<N;i++) {
			token = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			p[i] = new Point(x,y);
		}

		//組み合わせ全探索
		//1つ目
		for(int i=0;i<N-2;i++) {
			//2つ目
			for(int j=i+1;j<N-1;j++) {
				//3つ目
				for(int k= j+1;k<N;k++) {
					int x1 = p[i].x-p[k].x;
					int x2 = p[j].x-p[k].x;
					int y1 = p[i].y-p[k].y;
					int y2 = p[j].y-p[k].y;
					if(x1*y2 == x2*y1) {
						System.out.println("Yes");
						return;
					}
				}
			}
		}
		System.out.println("No");
	}

}

