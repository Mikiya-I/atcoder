package algorithm;

import java.util.List;

public class BinarySearchSample {
	
	int binarySearch(List<Integer> list, int x) {
		int left = -1;
		int right = list.size();
		while(right-left >1) {
			int mid= (left+right)/2;
			if(list.get(mid) >=x) {
				right = mid;
			}else {
				left = mid;
			}
		}
		return right;
	 }

}
