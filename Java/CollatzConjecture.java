import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CollatzConjecture {
	public static final long MAX = 10000000L;
	public static final long START = 1;
	public static long maxPath = 0;
	public static long maxStart = 0;

	public static void main(String[] args) {
		ArrayList<Long> path = new ArrayList<Long>();
		HashMap<Long, Long> lengthMap = new HashMap<Long, Long>();
		HashSet<Long> keys = new HashSet<Long>();
		long op = 0;
		long length = 0;
		for (long i = START; i <= MAX; i++) {
//			if (i % 10000000 == 0 && i > 10000000) {
//				System.out.println(i);
//			}
//			path.clear();
//			path.add(i);
			if (op < 0) {
				System.out.println(i);
				break;
			}
			op = i;
			length = 1;
			while (op != 1) {
//				System.out.printf("%d\n", op);
//				System.out.println(length);
//				if (keys.contains(op)) {
//					length += (lengthMap.get(op) - 1);
//					break;
//				}
				if (op % 2 == 0) {
					op = op / 2;
					length++;
				} else {
					op *= 3;
					op++;
					op = op / 2;
					length += 2;
				}
//				path.add(op);

			}
//			keys.add(i);
//			lengthMap.put(i, length);
			if (length >= maxPath) {
				maxPath = length;
				maxStart = i;
			}
//			System.out.printf("%d elements: ", path.size());
//			print(path);
		}
		System.out.printf("%d is the longest starting number with a path of length %d\n", maxStart, maxPath);
	}

	private static void print(List<Long> numList) {
		System.out.printf("[");
		for (Long x : numList) {
			System.out.printf("%d", x);
			if (x != numList.get(numList.size() - 1)) {
				System.out.printf(", ");
			}
		}
		System.out.printf("]\n");
	}
}
