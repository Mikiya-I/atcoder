package atCoderC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Beginner_057DigitsInMultiplication {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		long N = Long.parseLong(reader.readLine());
		if(N<=10) {
			System.out.println(1);
			return;
		}

		long root =0;
//		ニュートン法でNの平方根の近似値を求める(整数部分でok)
		ArrayList<Double> X = new ArrayList<Double>();
		X.add(1.0);
		for(int i=0;;i++) {
			double x= X.get(i)-(X.get(i)*X.get(i)-N) / (2*X.get(i));
			X.add(x);
			if(X.get(i)-X.get(i+1)<1.0 && i!=0) {
				root = X.get(i+1).longValue();
				break;
			}
		}

		if(N%root ==0) {
			System.out.println(String.valueOf(N/root).length());
			return;
		}

		if(N%root-1 ==0) {
			System.out.println(String.valueOf(N/(root-1)).length());
			return;
		}

//		計算数を減らす(2で割り切れない場合は最大の約数はN/2未満)
		if(N%2==1) {
			root/=2;
		}


		for(long i =root;i>0;i--) {
			if(N%i==0) {
				System.out.println(String.valueOf(N/i).length());
				return;
			}
		}

		System.out.println(String.valueOf(N).length());




	}

}

