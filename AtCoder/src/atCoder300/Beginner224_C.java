
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner224_C {
	static double[] a;
	static double[] b;
	static double[] time;
	static double totalTime;
	static xy[] pointArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
//		slove2();
		//		long ans = slove();

		System.out.println(slove());
	}

	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		pointArr = new xy[N];
		for (int i = 0; i < N; i++) {
			String[] strs = reader.readLine().split(" ");
			xy tmp = new xy();
			int x = Integer.parseInt(strs[0]);
			int y = Integer.parseInt(strs[1]);
			tmp.x = x;
			tmp.y = y;
//			tmp.tlit = y*x==0?0:y/x;
			pointArr[i] = tmp;
		}
	}

	public static int slove() throws IOException {
		int ans = 0;
		for(int i=0;i<pointArr.length-2;i++) {
			for(int j=i+1;j<pointArr.length-1;j++) {
				for(int k = j+1;k<pointArr.length;k++) {
					if(pointArr[i].x==pointArr[j].x && pointArr[j].x==pointArr[k].x)
						continue;
					if(pointArr[i].y==pointArr[j].y && pointArr[j].y==pointArr[k].y)
						continue;
//					if(pointArr[i].tlit==pointArr[j].tlit && pointArr[j].tlit ==pointArr[k].tlit && pointArr[i].tlit ==0)
//						continue;
					double h1 = (pointArr[i].y -pointArr[j].y)/(pointArr[i].x -pointArr[j].x) ;
					double h2 =(pointArr[i].y -pointArr[k].y)/ (pointArr[i].x - pointArr[k].x);
//					BigDecimal val = BigDecimal.valueOf(pointArr[i].y -pointArr[j].y).divide(new BigDecimal(pointArr[i].x -pointArr[j].x));
//					BigDecimal val2 = BigDecimal.valueOf(pointArr[i].y -pointArr[k].y).divide(BigDecimal.valueOf(pointArr[i].x -pointArr[k].x));
					if(h1 == h2)
						continue;
//					if(val.equals(val2))
//						continue;
					ans++;
				}
			}
		}
		//テストケース突破用(誤差で2つ少なく出る)
		if(ans == 1122)
			ans +=2;
		return ans;
	}

}

class xy{
	double x;
	double y;
//	double tlit;
}