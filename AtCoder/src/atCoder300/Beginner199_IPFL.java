package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner199_IPFL {

	public static void main(String[] args) throws NumberFormatException, IOException {

		slove();
	}

	public static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(reader.readLine());
		String s = reader.readLine();
		final int q = Integer.parseInt(reader.readLine());
		char[] f = s.substring(0,n).toCharArray();
		int first[] = new int[n];
		for(int i= 0;i<n;i++) {
			first[i] = f[i]-'A';
		}
		char[] sec = s.substring(n).toCharArray();
		int second[] = new int[n];
		for(int i= 0;i<n;i++) {
			second[i] = sec[i]-'A';
		}
		//tle
//		for(int i=0;i<q;i++) {
//			String[] strs = reader.readLine().split(" ");
//			int t = Integer.parseInt(strs[0]);
//			if(t==2) {
//				s = s.substring(n)+s.substring(0,n);
//			}else {
//				int a = Integer.parseInt(strs[1])-1;
//				int b = Integer.parseInt(strs[2])-1;
//				char[] c = s.toCharArray();
//				char tmp = c[a];
//				c[a] = c[b];
//				c[b] = tmp;
//				s = new String(c);
//			}
//		}
//		int changeCnt=0;
//		for(int i=0;i<q;i++) {
//			String[] strs = reader.readLine().split(" ");
//			int t = Integer.parseInt(strs[0]);
//			if(t==2) {
//				changeCnt++;
//				if(i==q-1&&changeCnt%2==1){
//					int[] tmp = first.clone();
//					first = second;
//					second = tmp;
//					changeCnt =0;
//				}
//			}else if(t==1){
//				if(changeCnt%2==1) {
//					int[] tmp = first.clone();
//					first = second;
//					second = tmp;
//					changeCnt =0;
//				}
//				int a = Integer.parseInt(strs[1])-1;
//				int b = Integer.parseInt(strs[2])-1;
//				int tmp;
//				if(a>=n) {
//					a-=n;
//					b-=n;
//					tmp = second[a];
//					second[a ] = second[b];
//					second[b] = tmp;
//				}else if(b>=n) {
//					b-=n;
//					tmp = first[a];
//					first[a] = second[b];
//					second[b] = tmp;
//				}else {
//					tmp = first[a];
//					first[a ] = first[b];
//					first[b] = tmp;
//				}
//			}
//		}
//		for(int i=0;i<n;i++) {
//			f[i] = (char)(first[i]+'A');
//			sec[i] = (char)(second[i]+'A');
//		}
		int changeCnt=0;
		for(int i=0;i<q;i++) {
			String[] strs = reader.readLine().split(" ");
			int t = Integer.parseInt(strs[0]);
			if(t==2) {
				changeCnt++;
				if(i==q-1&&changeCnt%2==1){
					char[] tmp = f.clone();
					f = sec;
					sec = tmp;
				}
			}else if(t==1){
				if(changeCnt%2==1) {
					char[] tmp = f.clone();
					f = sec;
					sec = tmp;
					changeCnt =0;
				}
				int a = Integer.parseInt(strs[1])-1;
				int b = Integer.parseInt(strs[2])-1;
				char tmp;
				if(a>=n) {
					a-=n;
					b-=n;
					tmp = sec[a];
					sec[a] = sec[b];
					sec[b] = tmp;
				}else if(b>=n) {
					b-=n;
					tmp = f[a];
					f[a] = sec[b];
					sec[b] = tmp;
				}else {
					tmp = f[a];
					f[a ] = f[b];
					f[b] = tmp;
				}
			}
		}
		System.out.print(f);
		System.out.print(sec);
	}
}
