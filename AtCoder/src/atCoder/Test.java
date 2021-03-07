package atCoder;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Random rand = new Random();
		Test main = new Test();
		int[] arr = new int[5];
		arr[0] = 2;

		while(true) {
			for(int i=1;i<5;i++) {
				arr[i] = rand.nextInt(10)+1;
			}
			int a = main.test(arr);
			int b= main.test2(arr);
			if(a!= b) {
				System.out.println(a+" " +b);
				break;
			}

		}

	}

	int test(int[] array) {
		int ans=Integer.MAX_VALUE;
		int[] arrA = new int[2];
		int[] arrB = new int[2];
		for(int i=1,j=0;i<5;i++) {
			if(i%2==1)
				arrA[j] = array[i];
			else {
				arrB[j]= array[j];
				j++;
			}
		}

		for(int i= 0;i<2;i++) {
			for(int j= 0;j<2;j++) {
				int time;
				if(i==j)
					time= arrA[i]+arrB[j];
				else
					time = Math.max(arrA[i], arrB[j]);
				if(ans > time)
					ans = time;
			}
		}
		return ans;
	}

	int test2(int[] array) {
		int minA = Integer.MAX_VALUE;
		int minB = Integer.MAX_VALUE;
		int secondA = Integer.MAX_VALUE;
		int secondB = Integer.MAX_VALUE;
		int minAIndex = -1;
		int minBIndex=-1;
		for(int i = 1;i<5;i++) {
			if(i%2==1) {
			if(minA> array[i]) {
				secondA = minA;
				minA = array[i];
				minAIndex=(i+1)/2;
			}else if(secondA > array[i] )
				secondA = array[i];
			}else {
				if(minB > array[i]) {
					secondB = minB;
					minB= array[i];
					minBIndex=i/2;
				}else if(secondB > array[i] )
					secondB =array[i];
			}
		}
		if(minAIndex != minBIndex)
			return Math.max(minA, minB);
		else {
			if(minA+minB <Math.min(secondA, secondB))
				return minA+minB;
			else
				return Math.min(secondA, secondB);
		}
	}
}


