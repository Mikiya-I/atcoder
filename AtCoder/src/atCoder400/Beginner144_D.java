package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner144_D {
	public static void main(String[] args) throws IOException {
//		slove();
		double  ans = slove();
		System.out.println(ans);
	}
	
	public static double slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		double a = Integer.parseInt(strs[0]);
		double b = Integer.parseInt(strs[1]);
		double x = Integer.parseInt(strs[2]);
		
		boolean overHalf;
		//水が半分以上を占めていたら空間が、そうでなければ水があふれる直前に三角形になる
		if(a*b/2 < x/a) {
			overHalf=true;
		}else {
			overHalf=false;
		}
		//水か空間の小さい方の面積を求める
		double m;
		if(overHalf)
			m=a*b - x/a;
		else 
			m=x/a;
		
		//あふれる直前の三角形の底辺(高さはbであると確定)
		double btm = m*2/b;
		//三平方の定理で斜辺を計算
		double hypotenuse = Math.sqrt(Math.pow(b, 2)+Math.pow(btm, 2));
		//斜辺と底辺間の角度が答えになる
		double ans = Math.asin(b/hypotenuse);
		ans= Math.toDegrees(ans);
		return ans;
	}
}
