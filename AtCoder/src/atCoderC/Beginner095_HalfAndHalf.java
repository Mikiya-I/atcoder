package atCoderC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner095_HalfAndHalf {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    String[] strs = reader.readLine().split(" ");
	    int A = Integer.parseInt(strs[0]);
	    int B = Integer.parseInt(strs[1]);
	    int C = Integer.parseInt(strs[2]);
	    int X = Integer.parseInt(strs[3]);
	    int Y = Integer.parseInt(strs[4]);

	    int c=C*2;//計算用
	    int big = X>Y?X:Y; //多い方の枚数
	    int ans =0;


//	    Aを買わない
	    if(A>=c ) {
	    	if(B>=c) {//Bも買わない
	    		ans = c * big;
	    	}else {//Bは単品
				ans = Y>X?B*(Y-X) + c * X : c*X;
			}
	    }
	    //Aは単品
	    else if (B>=c) {
			ans =X>Y ? A*(X-Y) + c*Y : c*Y;
		}
	    //足りない分だけ単品
	    else if(A+B >c) {
			ans = X>Y? A*(X-Y)+c*Y : B*(Y-X)+c*X;
		}
	    //全部単品
	    else {
			ans = A*X + B*Y;
		}

	    System.out.println(ans);

	}

}
