package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner114_755 {
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(slove());
		
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		if(N<357) {
			return 0;
		}
		ans = 0;
		//dfs
		dfs(0,N);
		return ans;
	}
	
	public static void dfs(long x,int n) {
		if(x>n) {
			return;
		}
		if(is357(x)) {
			ans++;
		}
		dfs(x*10+3,n);
		dfs(x*10+5,n);
		dfs(x*10+7,n);
		return;
	}
	
	public static boolean is357(long x) {
		boolean find3=false,find5=false,find7 = false;
		while(x>1) {
			long mod = x%10;
			if(mod==3)
				find3 = true;
			if(mod==5)
				find5 = true;
			if(mod==7)
				find7 =true;
			if(find3&& find5&&find7) {
				return true;
			}
			x/=10;
		}
		return false;
	}
}
