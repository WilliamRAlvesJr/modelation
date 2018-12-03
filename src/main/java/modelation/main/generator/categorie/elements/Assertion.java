package modelation.main.generator.categorie.elements;

import java.util.HashMap;

import modelation.main.generator.categorie.CategorieObject;

public class Assertion implements IElements {
	
	HashMap<String, String> assertions = new HashMap<>();

	public void addAssertion(String klass, String assertion) {
		this.assertions.put(klass, assertion);
	}
	
	public String performAssertion(Actions action) {
		String klass = action.getNextCategorie();
		CategorieObject.setActualKlass(klass);
		if (assertions.containsKey(klass))
			return assertions.get(klass);
		else
			return "(Insira uma assercao valida)";
	}
}
