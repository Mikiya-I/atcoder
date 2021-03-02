package atCoder400;

import java.io.IOException;
import java.util.Scanner;

public class Beginner191_CircleLatticePoints {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double r = sc.nextDouble();

		long X = Math.round(x * 10000);
		long Y = Math.round(y * 10000);
		long R = Math.round(r * 10000);

		//一番小さいx座標
		long minX = ((X-R)/10000-1)*10000;
		//一番大きいx座標
		long maxX =  ((X+R)/10000+1)*10000;
		System.out.println(minX);
		System.out.println(maxX);
		System.out.println(minX-maxX);

		long ans = 0;
		for(long i= minX; i<= maxX;i+=10000) {
			//三平方
			long R2 = (long)Math.pow(R,2);//斜辺
			long yy = (long) Math.pow(X-i,2);//底辺
			long  tmp = R2-yy;//対辺の2乗
			if(tmp >= 0) {
				long  len = (long)Math.sqrt(tmp);//x=iの時のy軸の長さ
				long yMax = (Y+len)/10000;
				long yMin = (Y-len)/10000;
				ans += yMax - yMin;
			}

		}
		System.out.println(ans);
	}
}