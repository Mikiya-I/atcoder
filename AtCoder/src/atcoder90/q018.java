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
		
		final int Q = Integer.parseInt(reader.readLine());
		for(int i=0;i<Q;i++) {
			int t = Integer.parseInt(reader.readLine());
			double deg;
			if(t==0) {
				deg=0;
			}else {
				deg =  360*(t%T)/T;
			}
			double tmpZ = L/2 -L/2 * Math.cos(deg);
			double tmpY = L/2*Math.sin(deg)*-1;
			double differenceY = Math.abs(tmpY-Y);
//			double edge = Math.sqrt(Math.pow(differenceY, 2) + Math.pow(tmpZ, 2));
//			double hypo = Math.sqrt(Math.pow(X, 2)+ Math.pow(edge, 2));
//			double cDeg = Math.acos(X/hypo);
//			sb.append(Math.toDegrees(cDeg));
//			sb.append("\n");
			double hypo = Math.sqrt(Math.pow(X, 2)+ Math.pow(tmpZ, 2));
			double cDeg = Math.acos(X/hypo);
			sb.append(Math.toDegrees(cDeg));
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
