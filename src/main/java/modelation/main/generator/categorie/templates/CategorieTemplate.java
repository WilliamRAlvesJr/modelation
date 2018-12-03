package modelation.main.generator.categorie.templates;

import modelation.main.generator.categorie.CategorieObject;
import osmo.tester.annotation.AfterTest;
import osmo.tester.annotation.BeforeSuite;
import osmo.tester.annotation.BeforeTest;
import osmo.tester.annotation.TestStep;

public abstract class CategorieTemplate extends CategorieObject {
	
	@BeforeSuite
	public abstract void beforeTest();
	
	@Override
	protected abstract void setup();
	
	@BeforeTest
	public abstract void attributes();
	
	@TestStep("actions")
	public abstract void actions();
	
	@AfterTest
	public abstract void assertions();
}