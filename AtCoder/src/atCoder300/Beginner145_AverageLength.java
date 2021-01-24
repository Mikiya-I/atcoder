package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Beginner145_AverageLength {
	static class Factorial{
		int factorial(int n) {
			int result =1;
			for(int i=n;i>1;i--) {
				result *=i;
			}
			return result;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());

		List<Pair145> list = new ArrayList<Pair145>();
		for(int i=0;i<N;i++) {
			Pair145 p = new Pair145();
			token = new StringTokenizer(reader.readLine());
			p.x = Integer.parseInt(token.nextToken());
			p.y = Integer.parseInt(token.nextToken());
			list.add(p);
		}

		double sum = 0;
		//線分を全て合計する
		for(int i =0;i<N-1;i++) {
			Pair145 current = list.get(i);
			for(int j=i+1;j<N;j++) {
				Pair145 current2 = list.get(j);
				sum += Math.sqrt(Math.pow(current.x-current2.x,2)+Math.pow(current.y-current2.y,2));
			}
		}

		Factorial f = new Factorial();
		//全部の合計
		int fact = f.factorial(N-1);
		double allSum = 2*(fact * sum);

		double result = allSum/f.factorial(N);

		System.out.println(result);
	}

}

class Pair145{
	int x;
	int y;
}