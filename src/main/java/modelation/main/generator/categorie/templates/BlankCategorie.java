package modelation.main.generator.categorie.templates;

import modelation.main.generator.categorie.CategorieObject;
import osmo.tester.annotation.AfterSuite;
import osmo.tester.annotation.TestStep;

public class BlankCategorie extends CategorieObject {

	@Override
	public boolean executableRule() {
		return true;
	}
	
	@Override
	protected void setup() {}
	
	@AfterSuite
	public void endSuit() {
		System.out.printf("\n");
	}
	
	@TestStep("attributes")
	public void attributes() {}
	
	@TestStep("actions")
	public void actions() {}
	
	@TestStep("assertions")
	public void assertions() {}
}
