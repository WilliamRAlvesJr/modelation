package modelation.main.generator.categorie;

import osmo.tester.annotation.Guard;

public abstract class CategorieRules extends CategorieController {
	
	CategorieRules() {
		super();
	}

	public boolean executableRule() {
		return CategorieObject.getActualKlass().equals(klass);
	}

	@Guard("all")
	public boolean block() {
		return executableRule();
	}
}
