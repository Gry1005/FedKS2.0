package wwwFedS.CrossDomain.parse;

import java.util.ArrayList;
import java.util.HashMap;

import wwwFedS.CrossDomain.util.InitialHelper;


public class Test {

	public static void main(String[] args) throws Exception {
		ParsingUnit pUnit = new ParsingUnit();
		InitialHelper iHelper = new InitialHelper();
		iHelper.init();
		
		HashMap<String, HashMap<String, ArrayList<String>>> query = new HashMap<>();

		HashMap<String, ArrayList<String>> h1 = new HashMap<>();
		ArrayList<String> oArrayList0 = new ArrayList<>();
		oArrayList0.add("<http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugs/DB01397>");
		oArrayList0.add("<http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugs/DB01398>");
		oArrayList0.add("<http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugs/DB01399>");
		h1.put("<http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/drugs>", oArrayList0);

		ArrayList<String> oArrayList1 = new ArrayList<>();
		oArrayList1.add("<http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugs/DB01397>");
		oArrayList1.add("<http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugs/DB01398>");
		oArrayList1.add("<http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugs/DB01399>");
		h1.put("<http://www4.wiwiss.fu-berlin.de/drugbank/vocab/resource/class/Offer>", oArrayList1);

		HashMap<String, ArrayList<String>> h2 = new HashMap<>();
		ArrayList<String> oArrayList2 = new ArrayList<>();
		oArrayList2.add("<http://dbpedia.org/resource/John_Robert_Vane>");
		h2.put("<http://dbpedia.org/ontology/Scientist>", oArrayList2);

		ArrayList<String> oArrayList3 = new ArrayList<>();
		oArrayList3.add("<http://dbpedia.org/resource/John_Robert_Vane>");
		h2.put("<http://dbpedia.org/ontology/Person>", oArrayList3);

		query.put("asprin", h1);
		query.put("john robert vane", h2);
		
		
		pUnit.Parse(query,iHelper);
		System.out.println(pUnit.toString());
		/*for (KeyMaterial kMaterial : pUnit.Query) {
			System.out.println(kMaterial.toString());
		}*/
	}
}
