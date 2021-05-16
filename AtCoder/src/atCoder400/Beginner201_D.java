package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner201_D {

	public static void main(String[] args) throws IOException {
		
		String ans = slove();
		System.out.println(ans);
	}
 
	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String[] strs = reader.readLine().split(" ");
		final int H = Integer.parseInt(strs[0]);
		final int W = Integer.parseInt(strs[1]);
		
		// 青マスをtrueにする
		boolean[][] field = new boolean[H][W];
		for(int i= 0;i<H;i++) {
			char[] line = reader.readLine().toCharArray();
			for(int j=0;j<W;j++) {
				field[i][j] = line[j]=='+';
			}
		}
		
		int h =0;
		int w = 0;
		int takaP =0;
		int aokiP =0;
//		while(h!=H && w!=W) {
//			
//		}
		for(int i= 1;i<H;i++) {
			for(int j= 0;j<W;j++) {
				if(field[i][j]) {
					if((i+j)%2 == 1) {
						takaP++;
					}else {
						aokiP++;
					}
				}
			}
		}
		
		int takaP2 =0;
		int aokiP2 =0;
		for(int i= 0;i<H;i++) {
			for(int j= 1;j<W;j++) {
				if(field[i][j]) {
					if((i+j)%2 == 1) {
						takaP2++;
					}else {
						aokiP2++;
					}
				}
			}
		}
		
		String ans ;
		if(takaP == aokiP && takaP2 == aokiP2) {
			ans = "Draw";
		}else if(takaP > aokiP || takaP2>aokiP2){
			ans = "Takahashi";
		}else {
			ans = "Aoki";
		}
		return ans;
	}
}
