package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Beginner199zoneD {

	public static void main(String[] args) throws IOException {
		String ans = slove2();
		System.out.println(ans);
	}
	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		char[] c = str.toCharArray();
		
		List<Character> t = new ArrayList<>();
		boolean isReverse = false;
		for(int i=0;i<c.length;i++) {
			if(c[i]=='R') {
				isReverse = !isReverse;
			}else if(!isReverse) {
				if(t.size()>1 &&t.get(t.size()-1)==c[i]) {
					t.remove(t.size()-1);
				}else{
					t.add(c[i]);
				}
//				if(t.size()>1) {
//					if(t.get(t.size()-1)== t.get(t.size()-2)) {
//						t.remove(t.size()-1);
//						t.remove(t.size()-1);
//					}
//				}
			}else {
				if(t.size()>1&c[i]==t.get(0)) {
					t.remove(0);
				}else {
					t.add(0,c[i]);
				}
//				
//				if(t.size()>1) {
//					if(t.get(0)== t.get(1)) {
//						t.remove(0);
//						t.remove(0);
//					}
//				}
			}
		}
		char[] result = new char[t.size()];
		if(!isReverse) {
	 		for(int i=0;i<t.size();i++) {
	 			result[i] = t.get(i);
	 		}
		}else {
			for(int i=t.size()-1;i>=0;i--) {
	 			result[t.size()-1-i] = t.get(i);
	 		}
		}
		
 		String ans = String.valueOf(result);
		return ans;
	}
	
	public static String slove2() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		char[] c = str.toCharArray();
		
		char[] T = new char[c.length];
		boolean isReverse = false;
		int index = 0;
		for(int i=0;i<c.length;i++) {
			if(c[i]=='R') {
				isReverse = !isReverse;
			}else if(!isReverse) {
				if(index>0&&T[index-1]==c[i]) {
					index--;
				}else {
					T[index] =c[i];
					index++;
				}
			}else {
				if(index>0&&T[index-1]==c[c.length-i]) {
					index--;
				}else {
					T[index] = c[c.length-i];
					index++;
				}
			}
		}
		
 		String ans = String.valueOf(T);
		return ans;
	}

}
