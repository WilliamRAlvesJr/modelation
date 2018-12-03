package modelation.main.generator.categorie;

import modelation.main.generator.categorie.elements.Actions;
import modelation.main.generator.categorie.elements.Assertion;
import modelation.main.generator.categorie.elements.Attributes;

public abstract class CategorieController implements GuaranteeRule {

	protected String klass;
	private static String actualKlass;

	protected Attributes attributes = new Attributes();
	protected Actions actions = new Actions();
	protected Assertion assertions = new Assertion();
	
	protected CategorieController() {
		setKlass();
		setup();
	}
	
	private void setKlass() {
		this.klass = getClass().getName();
	}

	protected abstract void setup();

	public static String getActualKlass() {
		return actualKlass;
	}

	public static void setActualKlass(String actualKlass) {
		CategorieController.actualKlass = actualKlass;
	}
}
