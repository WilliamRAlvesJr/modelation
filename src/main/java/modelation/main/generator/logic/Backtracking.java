package modelation.main.generator.logic;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

	static List<String> vector = new ArrayList<>();
	static int length;
	static List<Boolean> existInVector = new ArrayList<>();

	public static List<List<String>> perform(List<String> list) {
		Backtracking.vector = list; 
		Backtracking.length = list.size();
		List<String> result = new ArrayList<>();
		List<List<String>> resultSet = new ArrayList<>();

		backtracking(Backtracking.vector, Backtracking.existInVector, 0, Backtracking.length, result, resultSet);

		return resultSet;
	}

	private static void backtracking(List<String> strings, List<Boolean> exist, int i, int lenght, List<String> result, List<List<String>> resultSet) {
		if (i == lenght) {
			for (int j = 0; j < lenght; j++) {
				if (exist.get(j) == true) {
					result.add(strings.get(j));
				}
			}
			resultSet.add(result);
		}
		else {
			exist.add(i, true);
			backtracking(strings, exist, i+1, lenght, new ArrayList<>(), resultSet);
			exist.add(i, false);
			backtracking(strings, exist, i+1, lenght, new ArrayList<>(), resultSet);
		}
	}
}
