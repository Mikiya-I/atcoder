package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Beginner180_CreamPuff {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Long N = Long.parseLong(reader.readLine());
		int n = (int) Math.sqrt(N);
		List<Long> list = new ArrayList<Long>();

		for(int i= 1;i<=n;i++) {
			if(N%i==0) {
				System.out.println(i);
				if(N/i != n)
					list.add((N/i));
			}
		}
		for(int i = list.size()-1;i>=0;i--) {
			System.out.println(list.get(i));
		}

	}

}

