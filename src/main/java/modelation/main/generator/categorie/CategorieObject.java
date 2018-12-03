package modelation.main.generator.categorie;

import java.util.ArrayList;
import java.util.List;

public abstract class CategorieObject extends CategorieRules {
	
	public CategorieObject addAttributes(String attributes) {
		this.attributes.addAttribute(attributes);
		return this;
	}
	public CategorieObject addDefaultAttributes(String...attributes) {
		List<String> attributeList = new ArrayList<>();
		for (String attribute : attributes) {
			attributeList.add(attribute);
		}
		
		this.attributes.addDefaultAttributes(attributeList);
		return this;
	}
	
	public CategorieObject addSwitcher(String switcher) {
		this.attributes.addSwitcher(switcher);
		return this;
	}
	
	public CategorieObject addDefaultSwitcher(String switcher) {
		this.attributes.addDefaultSwitcher(switcher);
		return this;
	}
	

	public CategorieObject addAction(String action, Class<?> nextState) {
		actions.addAction(action, nextState.getName());
		attributes.incrementExecutionNumber();
		return this;
	}

	public CategorieObject addDefaultAction(String action, Class<?> nextState) {
		actions.addDefaultAction(action, nextState.getName());
		return this;
	}

	public CategorieObject addAssertion(Class<?> klass, String assertion) {
		assertions.addAssertion(klass.getName(), assertion);
		return this;
	}
}

