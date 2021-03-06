package wwwFedS.CrossDomain.parse;

import java.util.ArrayList;

public class calComb {

	/**
	 * 非递归计算所有组合
	 * 
	 * @param inputList 所有数组的列表
	 */
	public ArrayList<ArrayList<Integer>> calculateCombinationInt(ArrayList<ArrayList<Integer>> inputList) {
		ArrayList<Integer> combination = new ArrayList<Integer>();
		int n = inputList.size();
		for (int i = 0; i < n; i++) {
			combination.add(0);
		}
		int i = 0;
		ArrayList<ArrayList<Integer>> allQuery = new ArrayList<>();
		boolean isContinue = false;
		do {
			// 打印一次循环生成的组合
			ArrayList<Integer> oneQuery = new ArrayList<>();
			for (int j = 0; j < n; j++) {

				// System.out.print(inputList.get(j).get(combination.get(j)) + ", ");
				oneQuery.add(inputList.get(j).get(combination.get(j)));
			}
			// System.out.println();
			allQuery.add(oneQuery);
			i++;
			combination.set(n - 1, i);
			for (int j = n - 1; j >= 0; j--) {
				if (combination.get(j) >= inputList.get(j).size()) {
					combination.set(j, 0);
					i = 0;
					if (j - 1 >= 0) {
						combination.set(j - 1, combination.get(j - 1) + 1);
					}
				}
			}
			isContinue = false;
			for (Integer integer : combination) {
				if (integer != 0) {
					isContinue = true;
				}
			}
		} while (isContinue);
		return allQuery;
	}
	
	
	public ArrayList<String> calculateCombinationStr(ArrayList<ArrayList<String>> inputList) {
		ArrayList<Integer> combination = new ArrayList<Integer>();
		int n = inputList.size();
		for (int i = 0; i < n; i++) {
			combination.add(0);
		}
		int i = 0;
		ArrayList<ArrayList<String>> allQuery = new ArrayList<>();
		boolean isContinue = false;
		do {
			// 打印一次循环生成的组合
			ArrayList<String> oneQuery = new ArrayList<>();
			for (int j = 0; j < n; j++) {

				// System.out.print(inputList.get(j).get(combination.get(j)) + ", ");
				oneQuery.add(inputList.get(j).get(combination.get(j)));
			}
			// System.out.println();
			allQuery.add(oneQuery);
			i++;
			combination.set(n - 1, i);
			for (int j = n - 1; j >= 0; j--) {
				if (combination.get(j) >= inputList.get(j).size()) {
					combination.set(j, 0);
					i = 0;
					if (j - 1 >= 0) {
						combination.set(j - 1, combination.get(j - 1) + 1);
					}
				}
			}
			isContinue = false;
			for (Integer integer : combination) {
				if (integer != 0) {
					isContinue = true;
				}
			}
		} while (isContinue);
		
		ArrayList<String> sList = new ArrayList<>();
		for (ArrayList<String> arrayList : allQuery ) {
			String str = "";
			for (String s : arrayList) {
				str+=s;
			}
			if (!str.equals("")) {
				sList.add(str);
			}
		}
		return sList;
	}
}
