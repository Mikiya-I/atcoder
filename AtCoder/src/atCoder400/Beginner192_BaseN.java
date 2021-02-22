package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner192_BaseN {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		final String X = reader.readLine();
		int[] arr = new int[X.length()];
		final Long M = Long.parseLong(reader.readLine());
		reader.close();

		//1桁のケース
		if(X.length()==1) {
			if(M <= Integer.parseInt(X) ) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			return;
		}

		//最大の数字を求める
		long n=0;
		for(int i=0;i< X.length();i++) {
			arr[i] = X.charAt(i)-'0';
			if(n< arr[i])
				n= arr[i];
		}
		//n+1進数から
		n++;



		long left = n;
		long right = M;
		while(right-left >1) {
			long mid = (right+left)/2;
			if(Function(arr,M,mid))
				left = mid;
			else
				right = mid;
		}

		System.out.println(right-n);

//		label:
//		for(;;n++) {
//			BigInteger current = new BigInteger("0");
//			for(int i=0,index = XChar.length-1; i< XChar.length;i++) {
//				BigInteger nn = new BigInteger(String.valueOf(Integer.toString(n)));
//				BigInteger add = nn.pow(index-i);
//				BigInteger keta = new BigInteger(String.valueOf(XChar[i]));
//				BigInteger plusVal =keta.multiply(add);
//				current = current.add(plusVal);
//				//Mを超えたら終わり
//				if(new BigInteger(M.toString()).compareTo(current)==-1 )
//					break label;
//			}
//			ans ++;
//		}

	}

	//n進数の判定
	public static boolean Function(int[] arr ,long M,long n) {
		long current = 0;
		for(int i:arr) {
			long x = (M-i)/n;
			if(current > x) {
				return false;
			}
			current = current*n+i;
		}

		return true;
	}
}