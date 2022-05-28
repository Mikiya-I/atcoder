package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner253_B {
	static int H,W,x1,x2,y1,y2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		H = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
		boolean find1 = false;
		for(int i=0;i<H;i++) {
			char[] arr = reader.readLine().toCharArray();
			for(int j=0;j<arr.length;j++) {
				if(arr[j]=='o') {
					if(!find1) {
						y1 = i;
						x1 = j;
						find1 = true;
					}else {
						y2 = i;
						x2 = j;
					}
				}
			}
		}
		
		reader.close();
	}

	public static int slove() throws IOException {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}

}