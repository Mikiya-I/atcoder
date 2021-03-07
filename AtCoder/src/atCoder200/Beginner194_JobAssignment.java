package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner194_JobAssignment {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int  N = Integer.parseInt(reader.readLine());

		int minA = Integer.MAX_VALUE;
		int minB = Integer.MAX_VALUE;
		int secondA = Integer.MAX_VALUE;
		int secondB = Integer.MAX_VALUE;
		int minAIndex = -1;
		int minBIndex=-1;
		for(int i = 0;i<N;i++) {
			String[] str = reader.readLine().split(" ");
			int A = Integer.parseInt(str[0]);
			int B = Integer.parseInt(str[1]);
			if(minA> A) {
				secondA = minA;
				minA = A;
				minAIndex=i;
			}else if(secondA > A )
				secondA = A;

			if(minB > B) {
				secondB = minB;
				minB= B;
				minBIndex=i;
			}else if(secondB > B )
				secondB =B;
		}
		if(minAIndex != minBIndex)
			System.out.println(Math.max(minA, minB));
		else {
			if(minA+minB <Math.min(secondA, secondB))
				System.out.println(minA+minB);
			else
				System.out.println(Math.min(Math.max(minA, secondB), Math.max(minB, secondA)));
		}

	}
}
