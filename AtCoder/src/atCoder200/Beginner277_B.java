package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;

public class Beginner277_B {
	static Character[] one = { 'H' ,'D' ,'C' ,'S' };
	static Character[] two = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	static int N;
	static HashSet<String> S ;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
//		System.out.println(slove());
		slove();
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
//		S = new String[N];
		S = new HashSet<String>();
		for(int i=0;i<N;i++) {
			S.add(reader.readLine());
		}
		reader.close();
	}

	public static void slove() throws IOException {
		if(S.size()<N) {
			System.out.println("No");
			return;
		}
		HashSet<Character> s1 = new HashSet<>();
		HashSet<Character> s2 = new HashSet<Character>();
		Collections.addAll(s1,one);
		Collections.addAll(s2, two);
		for(String s:S) {
			char[] tmp = s.toCharArray();
			if(!s1.contains(tmp[0])) {
				System.out.println("No");
				return;
			}
			if(!s2.contains(tmp[1])) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

}