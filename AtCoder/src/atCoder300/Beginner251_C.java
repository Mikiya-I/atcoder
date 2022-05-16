
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Beginner251_C {
	static int N;
	static String[] s;
	static int[] t;
	static HashSet<String > originset = new  HashSet<String>();
	static HashSet<String > notOriginSet = new  HashSet<String>();
	
	static class Info implements Comparable<Info>{
		Integer point;
		Integer firstSubmit;
		String s;
		@Override
		public int compareTo(Info o) {
			if(this.point.compareTo(o.point)<0) {
				return 1;
			}else if(this.point.compareTo(o.point)>0) {
				return -1;
			}else {
				 if(this.firstSubmit.compareTo(o.firstSubmit)>0) {
					 return 1;
				 }else {
					 return -1;
				 }
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		s = new String[N];
		t = new int[N];
		for (int i=0;i<N;i++) {
			strs = reader.readLine().split(" ");
			s[i] = strs[0];
			t[i] = Integer.parseInt(strs[1]);
			if(originset.contains(strs[0])) {
				notOriginSet.add(strs[0]);
			}else if(!notOriginSet.contains(strs[0])) {
				originset.add(strs[0]);
			}
		}
		reader.close();
	}

	public static int slove() throws IOException {
		PriorityQueue<Info> que = new PriorityQueue<Info>();
		HashSet<String> used = new HashSet<String>();
		for(int i=0;i<N;i++) {
			if(!used.contains(s[i])) {
				Info info = new Info();
				info.firstSubmit= i;
				info.point= t[i];
				info.s = s[i];
				que.add(info);
				used.add(s[i]);
			}
		}
		
		return que.peek().firstSubmit+1;
	}
	
}