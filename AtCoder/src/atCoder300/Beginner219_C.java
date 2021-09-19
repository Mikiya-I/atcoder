
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Beginner219_C {
	static char[] dict;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//		 slove();
		//		long ans = slove();
		System.out.println(slove());
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] dict = reader.readLine().toCharArray();
		final int N = Integer.parseInt(reader.readLine());
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<N;i++) {
			list.add(reader.readLine());
		}
		Comparator<String> mySort = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				char[] O1 = o1.toCharArray();
			  	char[] O2 = o2.toCharArray();
			  	int min = Math.min(O1.length, O2.length);
			  	int compareIdx = -1;
			  	for(int i =0; i< min; i++) {
			  		if(O1[i] != O2[i]) {
			  			compareIdx = i;
			  			break;
			  		}
			  	}
			  	
			  	if(compareIdx  == -1) {
			  		if(O1.length > O2.length)
			  			return 1;
			  		else
			  			return -1;
			  	}
			      return mySortOrder(O1[compareIdx]) - mySortOrder(O2[compareIdx]);
			}
			
			// 独自のソート順の定義
			  public  int mySortOrder(char c) {
			      for(int i=0;i<dict.length;i++) {
			      	if(dict[i] == c)
			      		return i;
			      }
			      return 0;
			  }
		};
		
		Collections.sort(list, mySort);
		for(String s : list) {
			sb.append(s + "\n");
		}
		
		return sb.toString();
	}


}
