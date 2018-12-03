package modelation.main.generator.contraint;

import static modelation.main.generator.osmo.QuietTesterBuilder.generateCategorie;

import java.util.ArrayList;
import java.util.List;

import modelation.main.generator.categorie.CategorieObject;
import osmo.tester.annotation.BeforeSuite;

public abstract class ConstraintObject {
	
	public ConstraintObject() {
		setup();
	}

	protected List<Class<?>> categories = new ArrayList<>(); 

	@BeforeSuite
	public abstract void header();
	
	public void startConfiguration(CategorieObject categorie) {
		generateCategorie(categorie);
	}
	
	public ConstraintObject addKlasses(Class<?>...klasses) {
		for (Class<?> klass : klasses) {
			this.categories.add(klass);
		}
		return this;
	}
	
	protected void execCategories(List<Class<?>> categories) {
		startConfiguration(CategoriesFlow.getCategories(categories));
	}
	
	public abstract void setup();
}
