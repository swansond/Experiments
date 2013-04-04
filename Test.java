import java.util.*;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 5000000; i++) {
			list.add(rand.nextInt(8999999) + 1000000);
		}
		bucketSort(list.iterator());
	}
	
	
	public static void bucketSort(Iterator<Integer> iter) {
		byte[] masks = new byte[]{-128, 64, 32, 16, 8, 4, 2, 1};
		byte[] arr = new byte[9000000/8]; // 9999999 - 1000000 + 1
		while (iter.hasNext()) {
			int x = iter.next();
			arr[(x - 1000000) / 8] |= masks[(x - 1000000) % 8];
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < masks.length; j++) {
				if ((arr[i] & masks[j]) != 0) {
					System.out.println(8 * i + 1000000 + j);
				}
			}
		}
	}
}
