package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beginner077_SunukeFestival {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());

		int A[] = new int[N];
		int B[] = new int[N];
		int[] C = new int[N];

		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(token.nextToken());
		}

		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(token.nextToken());
		}

		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			C[i] = Integer.parseInt(token.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);

		int count = 0;
		for (int i =0,bIndex =0; i<N;i++) {
			for (int j=bIndex,cIndex=0;j<N;j++) {
				//AよりBが小さければスキップ
				if (B[j] <= A[i]) {
					bIndex = j+1;
					continue;
				}

				for (int k=cIndex;k<N;k++) {
					//BよりCが小さければスキップ
					if (C[k] <= B[j]) {
						cIndex = k+1;
						continue;
					}

					count++;
				}
			}
		}
		System.out.println(count);
	}

}
