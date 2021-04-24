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
		boolean changeFlg=false;
		for(int i=0;i<q;i++) {
			String[] strs = reader.readLine().split(" ");
			int t = Integer.parseInt(strs[0]);
			 if(t==1){
				int a = Integer.parseInt(strs[1])-1;
				int b = Integer.parseInt(strs[2])-1;
				if(!changeFlg) {
					changeElements(f, sec, a, b, n);
				}else {
					changeElements(sec, f, a, b, n);
				}
			}else {
				changeFlg = !changeFlg;
			}
		}
		if(!changeFlg) {
			System.out.print(f);
			System.out.print(sec);
		}else {
			System.out.print(sec);
			System.out.print(f);
		}
	}
	
	static void changeElements(char[] first,char[] second,int a,int b,int n) {
		char tmp;
		if(a>=n) {
			a-=n;
			b-=n;
			tmp = second[a];
			second[a] = second[b];
			second[b] = tmp;
		}else if(b>=n) {
			b-=n;
			tmp = first[a];
			first[a] = second[b];
			second[b] = tmp;
		}else {
			tmp = first[a];
			first[a ] = first[b];
			first[b] = tmp;
		}
	}
}
