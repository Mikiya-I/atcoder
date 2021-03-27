package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner197_Visibility {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner197_Visibility This = new Beginner197_Visibility();
		int ans =This.slove();
		System.out.println(ans);
	}

	public int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int H = Integer.parseInt(strs[0]);
		final int W = Integer.parseInt(strs[1]);
		final int Y = Integer.parseInt(strs[2]);
		final int X = Integer.parseInt(strs[3]);

		int minX=0;
		int maxX=W+1;
		int minY=0;
		int maxY=H+1;
		for(int i= 1;i<=H;i++) {
			char[] current = reader.readLine().toCharArray();
			//同じ行
			if(i== Y) {
				for(int j= 0;j<W;j++) {
					if(current[j] =='#') {
						if(j+1<X&&j+1>minX)
							minX=j+1;
						else if(j+1>X&&j+1<maxX)
							maxX=j+1;
					}
				}
			}
			//同じ列
			if(current[X-1]=='#') {
				if(i<Y&&i>minY)
					minY=i;
				else if(i>Y&&maxY>i)
					maxY=i;
			}
		}

		int param1=maxX-minX-1;
		int param2 = maxY-minY -1;
		return param1+param2-1;
	}
}
