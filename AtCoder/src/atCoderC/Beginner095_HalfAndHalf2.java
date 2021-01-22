package atCoderC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner095_HalfAndHalf2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int A = Integer.parseInt(token.nextToken());
		int B = Integer.parseInt(token.nextToken());
		int C = Integer.parseInt(token.nextToken());
		int AX = Integer.parseInt(token.nextToken());
		int BY = Integer.parseInt(token.nextToken());
		int c = C * 2;

		//Cのみ
//		if ((A * AX + B * BY) >= c * Math.max(AX, BY)) {
//			System.out.println(c * Math.max(AX, BY));
//			return;
//		}

		int min = Integer.MAX_VALUE;

		for(int i=0;i<=Math.max(AX, BY);i++) {
			//Cの値段
			int tmp = c*i;
			//iがAXより少ない(AXからiを引く)
			if(i<AX) tmp += A*(AX-i);

			//iがBYより少ない(BYからiを引く)
			if(i<BY) tmp += B*(BY-i);

			if(min>tmp) min=tmp;
		}

		System.out.println(min);

	}

}
