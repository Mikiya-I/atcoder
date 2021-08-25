package algorithm;

public class test {

	public static void main(String[] args) {
		NextPermutation permutation = new NextPermutation();
		int[] arr = new int[3];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
		}
		permutation.nextPermutation(arr);
	}

}
