package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner239_D {
	static int A,B,C,D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		A = Integer.parseInt(strs[0]);
		B = Integer.parseInt(strs[1]);
		C = Integer.parseInt(strs[2]);
		D = Integer.parseInt(strs[3]);
		reader.close();
	}

	public static String slove() throws IOException {
//		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=A;i<=B;i++) {
			boolean find = false;
			for(int j=C;j<=D;j++) {
				if(isPrime(i+j)) {
					find = true;
					break;
				}
			}
			if(!find)
				return "Takahashi";
		}
		return "Aoki";
	}
	
	
	static boolean isPrime(long x) {
		long loop = (long) Math.sqrt(x);
		if(x > 2 &&x %2 ==0 )
			return false;
		for(int i=3;i<=loop;i+=2) {
			if(x%i == 0)
				return false;
		}
		return true;
	}

}