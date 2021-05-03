package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Beginner199zoneD {

	public static void main(String[] args) throws IOException {
		String ans = slove2();
		System.out.println(ans);
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		char[] c = str.toCharArray();

		List<Character> t = new ArrayList<>();
		boolean isReverse = false;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'R') {
				isReverse = !isReverse;
			} else if (!isReverse) {
				if (t.size() > 1 && t.get(t.size() - 1) == c[i]) {
					t.remove(t.size() - 1);
				} else {
					t.add(c[i]);
				}
			} else {
				if (t.size() > 1 & c[i] == t.get(0)) {
					t.remove(0);
				} else {
					t.add(0, c[i]);
				}
			}
		}
		char[] result = new char[t.size()];
		if (!isReverse) {
			for (int i = 0; i < t.size(); i++) {
				result[i] = t.get(i);
			}
		} else {
			for (int i = t.size() - 1; i >= 0; i--) {
				result[t.size() - 1 - i] = t.get(i);
			}
		}

		String ans = String.valueOf(result);
		return ans;
	}

	public static String slove2() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		boolean isReverse = false;

		ArrayDeque<Character> deque = new ArrayDeque<>();
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (c == 'R') {
				isReverse = !isReverse;
			} else {
				if (!isReverse) {
					if (deque.isEmpty()) {
						deque.addLast(c);
					} else if (deque.peekLast() == c) {
						deque.pollLast();
					} else {
						deque.addLast(c);
					}
				} else {
					if (deque.isEmpty()) {
						deque.addFirst(c);
					} else if (deque.peekFirst() == c) {
						deque.pollFirst();
					} else {
						deque.addFirst(c);
					}
				}
			}
		}
		StringBuilder strBuilder = new StringBuilder();
		if (!isReverse) {
			while (!deque.isEmpty()) {
				strBuilder.append(deque.pollFirst());
			}
		} else {
			while (!deque.isEmpty()) {
				strBuilder.append(deque.pollLast());
			}
		}
		return strBuilder.toString();
	}

}
