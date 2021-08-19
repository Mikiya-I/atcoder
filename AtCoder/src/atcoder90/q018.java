package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q018 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new  StringBuilder();
		final int T = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		double L = Double.parseDouble(strs[0]);
		double X = Double.parseDouble(strs[1]);
		double Y = Double.parseDouble(strs[2]);
		double l2 = L/2;
		
		final int Q = Integer.parseInt(reader.readLine());
		for(int i=0;i<Q;i++) {
			int t = Integer.parseInt(reader.readLine());
			double deg =  360*(t%T)/T;
			double z = L/2 -L/2 * Math.cos(deg);
			double y = L*Math.sin(deg)*-1 / 2;
			double a = Math.sqrt(Math.pow(X, 2)+Math.pow((y-Y), 2));
//			double differenceY = Math.abs(tmpY-Y);
//			double edge = Math.sqrt(Math.pow(differenceY, 2) + Math.pow(tmpZ, 2));
//			double hypo = Math.sqrt(Math.pow(X, 2)+ Math.pow(edge, 2));
//			double hypo = Math.hypot(X, differenceY);
//			double cDeg = Math.atan2(tmpZ,differenceY);
			double cDeg = Math.atan2(z	,a);
			double ans  = cDeg*180/Math.PI;
			sb.append(Math.toDegrees(ans));
			sb.append("\n");
			
			double ky = -Math.sin(Math.PI * 2 * t/ T) * l2;
			double dxy = Math.hypot(X, Y - ky);
			double dz = l2 - Math.cos(Math.PI * 2 * t/ T) * l2;
			double ans2 = Math.atan2(dz, dxy) * 180 / Math.PI;
		}
		return sb.toString();
	}
}
