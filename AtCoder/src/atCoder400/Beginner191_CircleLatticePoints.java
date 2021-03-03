package atCoder400;

import java.io.IOException;
import java.util.Scanner;

public class Beginner191_CircleLatticePoints {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		final int e4 = 10000;

		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double r = sc.nextDouble();

		long X = Math.round(x * e4);
		long Y = Math.round(y * e4);
		long R = Math.round(r * e4);

		//一番小さいx座標
		long minX = ((X-R)/e4-1)*e4;
		//一番大きいx座標
		long maxX =  ((X+R)/e4+1)*e4;
//		System.out.println(minX);
//		System.out.println(maxX);
//		System.out.println(minX-maxX);

		long ans = 0;
		for(long i= minX; i<= maxX;i+=10000) {
			//x軸と平行の辺(底辺)
			long xLine = i-X;
			//半径が最長の辺でなければスキップ
			if(xLine * xLine > R*R)
				continue;
			//y軸と平行の辺(対辺)
			long yLine = (long) (Math.sqrt(R * R - xLine * xLine) / e4) * e4;
			//x=iの時のyの最大値
			long tmpMaxY = (Y + yLine) / e4 * e4;
			//誤差修正
			while (tmpMaxY < Y || (tmpMaxY - Y) * (tmpMaxY - Y) + xLine * xLine <= R * R) {
				tmpMaxY += e4;
			}
			long tmpMinY = ((Y - yLine) / e4 + 1) * e4;
			while (tmpMinY > Y || (tmpMinY - Y) * (tmpMinY - Y) + xLine * xLine <= R * R) {
				tmpMinY -= e4;
			}

			ans +=  (tmpMaxY - tmpMinY) / e4 - 1;
		}

		System.out.println(ans);
	}
}