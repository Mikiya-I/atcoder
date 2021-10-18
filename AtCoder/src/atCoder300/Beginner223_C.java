
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner223_C {
	static double[] a;
	static double[] b;
	static double[] time;
	static double totalTime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
//		slove2();
		//		long ans = slove();

		System.out.println(slove2());
	}

	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		a = new double[N];
		b = new double[N];
		time = new double[N];
		totalTime = 0;
		for (int i = 0; i < N; i++) {
			String[] strs = reader.readLine().split(" ");
			a[i] = Integer.parseInt(strs[0]) ;
			b[i] = Integer.parseInt(strs[1]);
			time[i] = (double)a[i] /(double) b[i];
			totalTime += time[i];
		}
		totalTime/=2;
	}

	public static double slove() throws IOException {

		//使う導火線の番号
		int tmpLeft = 0;
		int tmpRight = a.length - 1;
		//秒数
		double leftSec = 0;
		double rightSec = 0;
		//左右からの距離
		double fromLeft = 0;
		//左側が進んでいるか
		boolean forwardLeft = false;
		while (tmpLeft != tmpRight) {
			if (leftSec + time[tmpLeft] <= rightSec + time[tmpRight]) {
				leftSec += time[tmpLeft];
				fromLeft += a[tmpLeft];
				tmpLeft++;
				forwardLeft = false;
			} else {
				rightSec += time[tmpRight];
				tmpRight--;
				forwardLeft = true;
			}
		}
		double max = Math.max(leftSec, rightSec);
		double min = Math.min(leftSec, rightSec);
		if (forwardLeft)
			fromLeft += b[tmpRight] * (max - min);
		double remain = a[tmpRight] - b[tmpRight] * (max - min);
		double sec = remain / b[tmpLeft] / 2;
		fromLeft += b[tmpLeft] * sec;

		return (double) fromLeft;
	}

	public static double slove2() throws IOException {
		double tmpTime = 0;
		double ans = 0;
		for(int i=0;i<a.length;i++) {
			if(tmpTime+time[i] < totalTime) {
				ans +=(double) b[i] * time[i];
				tmpTime += time[i];
			}else {
				double lastTime = totalTime - tmpTime;
				ans += (double)b[i]*  lastTime;
				break;
			}
		}
		return  ans ;
	}
}