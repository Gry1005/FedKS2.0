package wwwFedS.run;

import java.util.ArrayList;
import java.util.HashMap;

public class ResultList {
	public ArrayList<ArrayList<String>> mappings;
	public ArrayList<String> variables;
	public ArrayList<String> queries;

	public ResultList() {
		mappings = new ArrayList<ArrayList<String>>();
		queries = new ArrayList<String>();
		variables = new ArrayList<String>();
	}

	@Override
	public String toString() {
		return variables.toString();
	}

	public void join(ResultList tmpResList) {
		if (tmpResList.mappings.size() == 0) {
			return;
		}

		if (this.mappings.size() == 0) {
			this.variables.addAll(tmpResList.variables);
			this.mappings.addAll(tmpResList.mappings);
			return;
		}

		ArrayList<Integer> joinPos = findCommonVariable(this.variables, tmpResList.variables);
		if (joinPos.size() == 0) {
			this.mappings.clear();
			return;
		}
		int this_pos = joinPos.get(0), other_pos = joinPos.get(1);

		ArrayList<ArrayList<String>> allResMappings = new ArrayList<ArrayList<String>>();
		this.variables.addAll(tmpResList.variables);

		HashMap<String, ArrayList<ArrayList<String>>> tmpHashMap = new HashMap<String, ArrayList<ArrayList<String>>>();
		if (this.mappings.size() < tmpResList.mappings.size()) {
			for (int i = 0; i < this.mappings.size(); i++) {
				if (!tmpHashMap.containsKey(this.mappings.get(i).get(this_pos))) {
					tmpHashMap.put(this.mappings.get(i).get(this_pos), new ArrayList<ArrayList<String>>());
				}
				tmpHashMap.get(this.mappings.get(i).get(this_pos)).add(this.mappings.get(i));
			}

			for (int i = 0; i < tmpResList.mappings.size(); i++) {
				if (tmpHashMap.containsKey(tmpResList.mappings.get(i).get(other_pos))) {
					ArrayList<ArrayList<String>> tmpList = tmpHashMap.get(tmpResList.mappings.get(i).get(other_pos));
					for (int j = 0; j < tmpList.size(); j++) {
						ArrayList<String> newMapping = new ArrayList<String>();
						newMapping.addAll(tmpList.get(j));
						newMapping.addAll(tmpResList.mappings.get(i));
						allResMappings.add(newMapping);
					}
				}
			}
		} else {
			for (int i = 0; i < tmpResList.mappings.size(); i++) {
				if (!tmpHashMap.containsKey(tmpResList.mappings.get(i).get(other_pos))) {
					tmpHashMap.put(tmpResList.mappings.get(i).get(other_pos), new ArrayList<ArrayList<String>>());
				}
				tmpHashMap.get(tmpResList.mappings.get(i).get(other_pos)).add(tmpResList.mappings.get(i));
			}

			for (int i = 0; i < this.mappings.size(); i++) {
				if (tmpHashMap.containsKey(this.mappings.get(i).get(this_pos))) {
					ArrayList<ArrayList<String>> tmpList = tmpHashMap.get(this.mappings.get(i).get(this_pos));
					for (int j = 0; j < tmpList.size(); j++) {
						ArrayList<String> newMapping = new ArrayList<String>();
						newMapping.addAll(this.mappings.get(i));
						newMapping.addAll(tmpList.get(j));
						allResMappings.add(newMapping);
					}
				}
			}
		}
		this.mappings.clear();
		this.mappings.addAll(allResMappings);
	}

	private ArrayList<Integer> findCommonVariable(ArrayList<String> variables2, ArrayList<String> variables3) {
		// System.out.println(variables2);
		// System.out.println(variables3);
		ArrayList<Integer> joinPos = new ArrayList<Integer>();
		for (int j = 0; j < variables2.size(); j++) {
			for (int i = 0; i < variables3.size(); i++) {
				if (variables3.get(i).equals(variables2.get(j))) {
					joinPos.add(j);
					joinPos.add(i);
					return joinPos;
				}
			}
		}

		return joinPos;
	}

	public void addAllResults(ResultList other) {
		if (this.variables.size() == 0 && other.variables.size() != 0) {
			this.variables.addAll(other.variables);
		}
		this.queries.addAll(other.queries);
		this.mappings.addAll(other.mappings);
	}

}
