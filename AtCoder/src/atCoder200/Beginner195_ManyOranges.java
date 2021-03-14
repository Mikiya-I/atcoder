package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner195_ManyOranges {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs= reader.readLine().split(" ");

		final int A = Integer.parseInt(strs[0]);
		final int B = Integer.parseInt(strs[1]);
		final int W = Integer.parseInt(strs[2])*1000;

		int min=Math.min(A, B);
		 int max = Math.max(A, B);

		 int Min = W/max;
		 int Max = W/min;
		 int ansMin= Integer.MAX_VALUE;
		 int ansMax =0;
		 //みかんの重さは小数もあり得る
		 //最小*個数<=重さ<=最大*個数が成立すればぴったりにできる(小数で調整できるため)
		 for(int i= Min;i<=Max;i++) {
			 if(i*min <= W && i*max>=W) {
				 ansMin = Math.min(ansMin, i);
				 ansMax= Math.max(ansMax, i);
			 }
		 }
		 if(ansMax!=0)
			 System.out.println(ansMin+" "+ansMax);
		 else{
			 System.out.println("UNSATISFIABLE");
		 }
	}
}
