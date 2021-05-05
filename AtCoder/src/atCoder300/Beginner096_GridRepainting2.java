package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner096_GridRepainting2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String ans = slove();
		System.out.println(ans);
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		final int H = Integer.parseInt(str[0]);
		final int W = Integer.parseInt(str[1]);
		
		boolean[][] map = new boolean[H+2][W+2];
		for(int i=1;i<=H;i++) {
			char[] current = reader.readLine().toCharArray();
 			for(int j=1;j<=W;j++) {
				map[i][j] = (current[j-1]=='#');
			}
		}
		
		for(int i=0;i<H;i++) {
 			for(int j=0;j<W;j++) {
 				if(map[i][j] && (!map[i-1][j]&& !map[i+1][j]&& !map[i][j-1]&&!map[i][j+1])) {
 					return "No";
 				}
			}
		}
		
		return "Yes";
	}
}
