import java.util.ArrayList;
import java.util.Arrays;

/**
 * Providing an integer array. Find all <x,y,z> triples, so
 * that x + y + z = 0. For example, for array
 * [-5, 0, 1, 5, 2, 3], the answer is [[-5, 0, 5],[-5, 2, 3]].
 */
public class FindTriple_c {
	public static ArrayList<ArrayList<Integer>> three_summary(int[] inputList) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (inputList.length < 3)
			return result;
		Arrays.sort(inputList);
		for (int i = 0; i < inputList.length - 2; i++) {
			if (i == 0 || inputList[i] > inputList[i - 1]) {

				int negative = -inputList[i];

				int s = i + 1;
				int e = inputList.length - 1;

				while (s < e) {
					if (inputList[s] + inputList[e] == negative) {
						int[] tmpResult = { inputList[i], inputList[s],
								inputList[e] };
						ArrayList<Integer> tmpList = new ArrayList<Integer>();
						for (int t : tmpResult) {
							tmpList.add(t);
						}

						result.add(tmpList);
						s++;
						e--;
						while (s < e && inputList[e] == inputList[e + 1])
							e--;

						while (s < e && inputList[s] == inputList[s - 1])
							s++;
					} else if (inputList[s] + inputList[e] < negative) {
						s++;
					} else {
						e--;
					}
				}

			}
		}
		return result;
	}
}
