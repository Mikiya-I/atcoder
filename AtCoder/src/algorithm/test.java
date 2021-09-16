package algorithm;

import java.util.Random;

public class test {

	public static void main(String[] args) {
		GridRotateSample test = new GridRotateSample();
		for(int i=0;i<40000;i++) {
			Random rand = new Random();
			int x = rand.nextInt(9)+1;
			int y = rand.nextInt(9)+1;
			boolean[][] a = new boolean[x][y];
			try {
				test.rotate(a);
			}catch (Exception e) {
				System.out.println(x);
				System.out.println(y);
			}
		}
		System.out.println("ok");
		
	}

}
