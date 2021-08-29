package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner216_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String strs[] = reader.readLine().split(".");
		double num= Double.parseDouble(reader.readLine());
//		int y = Integer.parseInt(strs[1]);
		int y = (int) (num*10%10);

		if(y<3)
			System.out.println((int)num+"-");
		else if(y>=7)
			System.out.println((int)num+"+");
		else
			System.out.println((int)num);
	}
}
