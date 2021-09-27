package sample;

public class Sample {
	private static void q1() {
		int X = 1234567890;
		int root = (int) (Math.sqrt(X) + 1);
		long sum = 0;

		for (int i = 1; i < root; i++) {
			if (X % i == 0) {
				sum += i;
				if (X / i <= 10000000)
					sum += X / i;
			}
		}
		System.out.println(sum);
	}

	private static void q2() {
		int[] sum = new int[33];
		sum[0] = 1;
		sum[1] = 0;
		sum[2] = 5;
		for (int i = 3; i < sum.length; i++) {
			sum[i] = sum[i - 1] + sum[i - 2] + sum[i - 3];
		}
		System.out.println(sum[31]);
	}

	private static void q3() {
		long X = 40000;
		long sum = 0;
		//30000台は先に計算しておく
		for (int i = 1; i < X; i++) {
			if (i % 3 == 0) {
				sum += i;
			} else {
				char[] arr = String.valueOf(i).toCharArray();
				for (char c : arr) {
					if (c == '3') {
						sum += i;
						break;
					}
				}
			}
		}
		System.out.println(sum);
	}

	private static void q4() {
		String str = "14159265358979323846264338327950288419"
				+ "716939937510582097494459230781640628620899"
				+ "862803482534211706798214808651328230664709"
				+ "38446095505822317253594081284811174502841027"
				+ "019385211055596446229489549303819644288109756"
				+ "6593344612847564823378678316527120190914564856"
				+ "692346034861045432664821339360726024914127372458"
				+ "70066063155881748815209209628292540917153643678925"
				+ "90360011330530548820466521384146951941511609433057270"
				+ "3657595919530921861173819326117931051185480744623799627"
				+ "495673518857527248912279381830119491298336733624406566430"
				+ "860213949463952247371907021798609437027705392171762931767523"
				+ "84674818467669405132000568127145263560827785771342757789609173"
				+ "6371787214684409012249534301465495853710507922796892589235420199"
				+ "56112129021960864034418159813629774771309960518707211349999998372"
				+ "97804995105973173281609631859502445945534690830264252230825334468503"
				+ "5261931188171010003137838752886587533208381420617177669147303";
		char[] arr = str.toCharArray();
		int[] cnts = new int[100];
		for(int i=1;i<arr.length;i++) {
			int tmp = (int )(arr[i-1] - 48)* 10 + (int)arr[i]-48;
			cnts[tmp]++;
		}
		int maxCnt= 0;
		int maxIndex = 0;
		for(int i=0;i<100;i++) {
			if(maxCnt < cnts[i]) {
				maxCnt = cnts[i];
				maxIndex = i;
			}
		}
		System.out.println(maxIndex);
	}
	
	private static void q5() {
		int cnt = 0;
		label:for(int i=10;i<1000000+1;i++) {
			int tmp =i;
			for(int j=0;j<5;j++) {
					if(tmp <10)
						continue label;
					tmp=q5Cal(tmp);
			}
			if(tmp<10)
				cnt++;
		}
		System.out.println(cnt);
	}
	private static int q5Cal(int i) {
		char[] arr = String.valueOf(i).toCharArray();
		int val = 1;
		for(char c: arr)
			val *= (int)c-48;
		
		return val;
	}
	
	private static void q6() {
		int row = 32;
		char[][] grid = new char[row][row];
		int total = row * row;
		int cnt = 0;
		while(cnt < total) {
			int code = 65;
			for(int i=0;i<row;i++) {
				code ++;
				if(code > 90)
					code = 65;
				grid[cnt][i] = (char)(code);
			}
			for(int i=cnt+1;i<row-cnt;i++) {
				code ++;
				if(code > 90)
					code = 65;
				grid[row-i-1][i] = (char)(code);
			}
		}
	}

}
